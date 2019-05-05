package com.enano.cloudbean.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enano.cloudbean.dtos.AgrochemicalApplicationDto;
import com.enano.cloudbean.dtos.ApplicationDto;
import com.enano.cloudbean.dtos.ItemAmountDto;
import com.enano.cloudbean.dtos.WithdrawAgrochemicalDto;
import com.enano.cloudbean.dtos.WithdrawItemDto;
import com.enano.cloudbean.entities.Agrochemical;
import com.enano.cloudbean.entities.AgrochemicalApplication;
import com.enano.cloudbean.entities.Application;
import com.enano.cloudbean.entities.RemoveAgrochemical;
import com.enano.cloudbean.repositories.ApplicationRepository;
import com.enano.cloudbean.repositories.AgrochemicalApplicationRepository;
import com.enano.cloudbean.repositories.AgrochemicalRepository;
import com.enano.cloudbean.repositories.RemoveAgrochemicalRepository;
import com.enano.report.AgrochemicalApplicationCostReport;
import com.enano.report.AgrochemicalStockReport;
import com.enano.report.AgrochemicalWithdrawReport;

@Service
public class AgrochemicalService {
  
  @Autowired
  private AgrochemicalRepository repo;
  
  @Autowired
  private RemoveAgrochemicalRepository repoWithdraw;
  
  @Autowired
  private ApplicationRepository repoApplication;
  
  @Autowired
  private AgrochemicalApplicationRepository repoAgroApp;
  
  public List<Agrochemical> listAll() {
    return repo.findAll();
  }
  
  public Agrochemical getOne(Long id) {
    return repo.getOne(id);
  }
  
  public void deleteOne(Long id) {
    repo.deleteById(id);
  }
  
  public Agrochemical save(Agrochemical agrochemical) {
    agrochemical.setId(null);
    return repo.saveAndFlush(agrochemical);
  }
  
  public Agrochemical edit(Agrochemical agrochemical) {
    agrochemical.setModificationDate(new Date());
    return repo.saveAndFlush(agrochemical);
  }
  
  public List<String> listAllDistincAgrochemicalNames() {
    return repo.listAllDistincAgrochemicalNames();
  }
  
  public Agrochemical addAmountToStock(ItemAmountDto item) {
    Agrochemical agrochemical = null;
    Float amount = item.getAmount();
    if (amount != null && amount > 0) {
      agrochemical = repo.getOne(item.getId());
      agrochemical.setModificationDate(new Date());
      agrochemical.setAmount(agrochemical.getAmount() + amount);
      agrochemical = repo.saveAndFlush(agrochemical);
    }
    return agrochemical;
  }

  public List<RemoveAgrochemical> withdrawAgrochemicals(WithdrawAgrochemicalDto withdrawOrder) throws Exception{
    List<RemoveAgrochemical> removeAgrochemicalList = new ArrayList<>();
    Agrochemical agrochemical;
    String workOrder = withdrawOrder.getWorkOrder();
    float withdrawAmt = 0;
    for (WithdrawItemDto item : withdrawOrder.getItems()) {
      withdrawAmt = item.getWithdrawAmt();
      agrochemical = repo.findById(item.getId()).get();
      if (checkIfStockExist(agrochemical, withdrawAmt)) {
        agrochemical = getWithdrawedAgrochemical(agrochemical, withdrawAmt);
        removeAgrochemicalList.add(new RemoveAgrochemical(workOrder, agrochemical, withdrawAmt));
      } else {
        throw new Exception("One or many agrochemical were not found.");
      }
    }
    return repoWithdraw.saveAll(removeAgrochemicalList); 
  }
  
  public List<RemoveAgrochemical> listAllWithdrawedAgrochemicals() {
    return repoWithdraw.findAll(); 
  }
  
  public List<Application> listAllAgrochemicalsApplications() {
    return repoApplication.findAll(); 
  }

  private boolean checkIfStockExist(Agrochemical agrochemical, float withdrawAmt) {
    return agrochemical != null && agrochemical.getAmount() >= withdrawAmt;
  }
  
  private Agrochemical getWithdrawedAgrochemical (Agrochemical agrochemical, float withdrawAmt) {
    agrochemical.setModificationDate(new Date());
    agrochemical.setAmount(agrochemical.getAmount() - withdrawAmt);
    return agrochemical;
  }

  @Transactional
  public Application saveAgrochemicalApplication(ApplicationDto agroApplication) {
    Application application = new Application();
    application.setApplicationDate(agroApplication.getApplicationDate());
    application.setApplicationNumber(agroApplication.getApplicationNumber());
    application.setApplicationType(agroApplication.getApplicationType());
    application.setHaAmount(agroApplication.getHaAmount());
    application.setLandBatch(agroApplication.getLandBatch());
    if (agroApplication.getId() == null || agroApplication.getId() < 0) {
      application.setId(null);
      final Application applicationResult = repoApplication.saveAndFlush(application);
      agroApplication.getItems().forEach(item -> item.setApplication(applicationResult));
      repoAgroApp.saveAll(agroApplication.getItems());
    } else {
      application.setId(agroApplication.getId());
      application = repoApplication.saveAndFlush(application);
    }
    return application;
  }

  @Transactional
  public void deleteApplication(Long id) {
    repoAgroApp.deleteByApplicationId(id);
    repoApplication.deleteById(id);
  }

  public List<AgrochemicalApplication> getApplicationDetailByApplicationId(Long id) {
    return repoAgroApp.findByApplicationId(id);
  }

  public void deleteOneAgrochemicalApplication(Long id) {
    repoAgroApp.deleteById(id);
  }

  public AgrochemicalApplication addAgrochemicalApplication(AgrochemicalApplicationDto appDetail) {
    AgrochemicalApplication entity = new AgrochemicalApplication();
    entity.setAgrochemical(appDetail.getAgrochemical());
    entity.setApplication(appDetail.getApplication());
    entity.setDosage(appDetail.getDosage());
    return repoAgroApp.saveAndFlush(entity);
  }
  
  public byte[] getApplicationReport() throws IOException {
    AgrochemicalApplicationCostReport excelBuilder = new AgrochemicalApplicationCostReport();
    excelBuilder.buildExcel(repoApplication.findAll());
    return excelBuilder.getReport();
  }

  public byte[] getWithdrawReport() throws IOException {
    AgrochemicalWithdrawReport excelBuilder = new AgrochemicalWithdrawReport();
    excelBuilder.buildExcel(repoWithdraw.findAll());
    return excelBuilder.getReport();
  }

  public byte[] getStockReport() throws IOException{
    AgrochemicalStockReport excelBuilder = new AgrochemicalStockReport();
    excelBuilder.buildExcel(repo.findAll());
    return excelBuilder.getReport();
  }

  public List<String> getAssociatedWithdraws(Long id) {
    List<String> withdrawList = repoWithdraw.getWorkOrderByAgrochemicalId(id.intValue());
    return withdrawList;
  }
}
