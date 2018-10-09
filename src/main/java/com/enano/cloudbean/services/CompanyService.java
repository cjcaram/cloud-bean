package com.enano.cloudbean.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.repositories.ComercialEntityRepository;
import com.enano.cloudbean.repositories.LocationRepository;
import com.enano.cloudbean.repositories.ResponsibleTypeRepository;

@Service
public class CompanyService {

  @Autowired
  private ComercialEntityRepository repo;
  
  @Autowired
  private LocationRepository locationRepo;
  
  @Autowired
  private ResponsibleTypeRepository respTypeRepo;

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

  public ComercialEntity save(CompanyDto company) {
    return repo.saveAndFlush(getComercialEntityFromCompanyDto(company));
  }

  public ComercialEntity edit(CompanyDto company) {
    ComercialEntity comercialEntity = getComercialEntityFromCompanyDto(company);
    comercialEntity.setId(company.getId().longValue());
    return repo.saveAndFlush(comercialEntity);
  }
  
  private ComercialEntity getComercialEntityFromCompanyDto(CompanyDto company) {
    ComercialEntity comercialEntity = new ComercialEntity();
    comercialEntity.setCuit(company.getCuit());
    comercialEntity.setMail(company.getMail());
    comercialEntity.setName(company.getName());
    comercialEntity.setObs(company.getObs());
    comercialEntity.setPhone(company.getPhone());
    comercialEntity.setLocation(locationRepo.getOne(company.getLocationId().longValue()));
    comercialEntity.setResponsibleType(respTypeRepo.getOne(company.getResponsibleType().longValue()));
    return comercialEntity;
  }

  public void deleteOne(long id) {
    repo.deleteById(id);
  }
  
}
