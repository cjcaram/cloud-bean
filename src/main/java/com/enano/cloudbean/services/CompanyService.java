package com.enano.cloudbean.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.BaseCompanyDto;
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
  
  private ModelMapper modelMapper = new ModelMapper();
  
  public ComercialEntity getCompanyById(long id){
    return repo.getOne(id);
  }

  public List<ComercialEntity> listAll() {
    return repo.findAll();
  }
  
  public List<CompanyDto> listAllCompanyDto() {
    List<ComercialEntity> comercialEntityList = repo.findAll();
    List<CompanyDto> companyDtoList = comercialEntityList.stream()
        .map(item -> modelMapper.map(item, CompanyDto.class))
        .collect(Collectors.toList());
    return companyDtoList;
  }
  
  public List<BaseCompanyDto> listAllBaseCompanyDto() {
    List<ComercialEntity> comercialEntityList = repo.findAll();
    List<BaseCompanyDto> baseCompanyDtoList = comercialEntityList.stream()
        .map(item -> modelMapper.map(item, BaseCompanyDto.class))
        .collect(Collectors.toList());
    return baseCompanyDtoList;
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
