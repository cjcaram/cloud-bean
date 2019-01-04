package com.enano.cloudbean.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.dtos.LandBatchDto;
import com.enano.cloudbean.entities.AgrochemicalApplication;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.entities.LandBatch;
import com.enano.cloudbean.repositories.LandBatchRepository;
import com.enano.cloudbean.repositories.LocationRepository;

@Service
public class LandBatchService {
  
  @Autowired
  private LandBatchRepository landBatchRepo;
  
  @Autowired
  private LocationRepository LocationRepo;
  
  public List<LandBatch> listAllLandBatch() {
    return landBatchRepo.findAll();
  }

  public LandBatch edit(LandBatchDto item) {
    LandBatch landBatch = getLandBatchEntity(item);
    landBatch.setId(item.getId());
    return landBatchRepo.saveAndFlush(landBatch);
  }

  public LandBatch save(LandBatchDto item) {
    LandBatch landBatch = getLandBatchEntity(item);
    landBatch.setId(null);
    return landBatchRepo.saveAndFlush(landBatch);
  }

  private LandBatch getLandBatchEntity(LandBatchDto item) {
    LandBatch landBatch = new LandBatch();
    landBatch.setName(item.getName());
    landBatch.setHaAmount(item.getHaAmount());
    landBatch.setNote(item.getNote());
    landBatch.setLand(LocationRepo.getOne(item.getParentId()));
    return landBatch;
  }
  
  public List<AgrochemicalApplication> getAgrochemicalApplicationAssociatedWithLandBatchId (Long id){
    List<AgrochemicalApplication> agrochAppList = new ArrayList<>();// companyRepo.findByLocation(repo.getOne(id.longValue()));
    return agrochAppList;
  }

  public void deleteOne(Long id) {
    landBatchRepo.deleteById(id);;
  }
}
