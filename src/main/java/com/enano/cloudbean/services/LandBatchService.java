package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.LandBatchDto;
import com.enano.cloudbean.entities.Application;
import com.enano.cloudbean.entities.LandBatch;
import com.enano.cloudbean.repositories.ApplicationRepository;
import com.enano.cloudbean.repositories.LandBatchRepository;
import com.enano.cloudbean.repositories.LocationRepository;

@Service
public class LandBatchService {
  
  @Autowired
  private LandBatchRepository landBatchRepo;
  
  @Autowired
  private LocationRepository locationRepo;
  
  @Autowired
  private ApplicationRepository agroAppRepo;
  
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
    landBatch.setLand(locationRepo.getOne(item.getParentId()));
    return landBatch;
  }
  
  public List<Application> getAgrochemicalApplicationAssociatedWithLandBatchId (Long id){
    List<Application> agrochAppList = agroAppRepo.findByLandBatchId(id);
    return agrochAppList;
  }

  public void deleteOne(Long id) {
    landBatchRepo.deleteById(id);
  }
}
