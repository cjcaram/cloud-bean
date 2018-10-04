package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.repositories.ComercialEntityRepository;

@Service
public class ComercialEntityService {

  @Autowired
  private ComercialEntityRepository repo;

  public ComercialEntity getCompanyById(long id){
    return repo.getOne(id);
  }

  public List<ComercialEntity> listAll() {
    return repo.findAll();
  }

  public ComercialEntity save(CompanyDto company) {
    ComercialEntity comercialEntity = new ComercialEntity();
    // transform company to Comercial Entity
    
    return repo.saveAndFlush(comercialEntity);
  }
  
  public ComercialEntity edit(CompanyDto company) {
    ComercialEntity comercialEntity = new ComercialEntity();
    // transform company to Comercial Entity
    
    return repo.saveAndFlush(comercialEntity);
  }

  public void deleteOne(long id) {
    repo.deleteById(id);
  }
  
}
