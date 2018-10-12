package com.enano.cloudbean.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.repositories.ComercialEntityRepository;
import com.enano.cloudbean.repositories.UserRepository;

@Service
public class CompanyService {

  @Autowired
  private ComercialEntityRepository repo;
  
  @Autowired
  private UserRepository userRepo;
  
  public ComercialEntity getCompanyById(long id){
    return repo.getOne(id);
  }

  public List<ComercialEntity> listAll() {
    return repo.findAll();
  }
  
  public List<CompanyDto> listAllCompanyDto() {
    List<ComercialEntity> comercialEntityList = repo.findAll();
    List<CompanyDto> companyDtoList = comercialEntityList.stream()
        .map(item -> getCompanyDtoFromComercialEntity(item))
        .collect(Collectors.toList());
    return companyDtoList;
  }

  private CompanyDto getCompanyDtoFromComercialEntity(ComercialEntity item) {
    CompanyDto company = new CompanyDto();
    company.setId(item.getId().intValue());
    company.setCuit(item.getCuit());
    company.setName(item.getName());
    company.setLocationId(item.getLocation().getId().intValue());
    return company;
  }

  public ComercialEntity save(ComercialEntity company) {
    return repo.saveAndFlush(company);
  }

  public ComercialEntity edit(ComercialEntity company) {
    return repo.saveAndFlush(company);
  }
  
  public List<String> getUsersAssociatedWithCompanyId (Integer id){
    List<String> userList = userRepo.getUserProfilesByCompanyId(id);
    return userList;
  }
  
  public void deleteOne(long id) {
    repo.deleteById(id);
  }
  
}
