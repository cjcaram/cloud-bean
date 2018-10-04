package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.LocationDto;
import com.enano.cloudbean.entities.Location;
import com.enano.cloudbean.repositories.LocationRepository;

@Service
public class LocationService {

  @Autowired
  private LocationRepository repo;

  public Location getLocationById(long id){
    return repo.getOne(id);
  }

  public List<Location> listAll() {
    return repo.findAll();
  }

  public Location save(LocationDto location) {
    Location locationEntity = new Location();
    // transform to dto
    
    return repo.saveAndFlush(locationEntity);
  }
  
  public Location edit(LocationDto location) {
    Location locationEntity = new Location();
    // transform to dto
    
    return repo.saveAndFlush(locationEntity);
  }

  public void deleteOne(long id) {
    repo.deleteById(id);
  }
}
