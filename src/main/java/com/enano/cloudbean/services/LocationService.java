package com.enano.cloudbean.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.BaseLocationDto;
import com.enano.cloudbean.dtos.BasicTreeViewDto;
import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.dtos.LandBatchDto;
import com.enano.cloudbean.dtos.LocationDto;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.entities.LandBatch;
import com.enano.cloudbean.entities.Location;
import com.enano.cloudbean.repositories.ComercialEntityRepository;
import com.enano.cloudbean.repositories.LocationRepository;

@Service
public class LocationService {

  @Autowired
  private LocationRepository repo;
  
  @Autowired
  private ComercialEntityRepository companyRepo;
  
  public Location getLocationById(long id){
    return repo.getOne(id);
  }

  public List<Location> listAll() {
    return repo.findAll();
  }
  
  public List<BasicTreeViewDto> getListOfBatchesPerLocation() {
    List<Location> locationList = repo.findAll();
    List<BasicTreeViewDto> treeViewList = new ArrayList<>();
    List<LandBatchDto> batchesItems = new ArrayList<>();
    BasicTreeViewDto treeItem;
    
    for (Location loc : locationList) {
      if (loc.getBatches() != null && loc.getBatches().size() > 0)
      {
        batchesItems = new ArrayList<>();
        treeItem = new BasicTreeViewDto();
        treeItem.setId(loc.getId());
        treeItem.setName(loc.getName());
        for (LandBatch batch  : loc.getBatches()) {
          batchesItems.add(new LandBatchDto(batch.getId(), batch.getName(), batch.getHaAmount(), batch.getNote()));
        }
        treeItem.setChildren(batchesItems);
        treeViewList.add(treeItem);
      }
    }
    return treeViewList;
  }

  public Location save(LocationDto locationDto) {
    locationDto.setId(null);
    return repo.saveAndFlush(getLocationFromLocationDto(locationDto));
  }
  
  public Location edit(LocationDto locationDto) {
    Location location = getLocationFromLocationDto(locationDto);
    location.setId(locationDto.getId().longValue());
    return repo.saveAndFlush(location);
  }

  public void deleteOne(Integer id) {
    repo.deleteById(id.longValue());
  }
  
  public List<CompanyDto> getCompaniesAssociatedWithLocationId (Integer id){
    List<ComercialEntity> companyList = companyRepo.findByLocation(repo.getOne(id.longValue()));
    List<CompanyDto> companyDtoList = companyList.stream().map(item -> {
      CompanyDto companyDto = new CompanyDto();
      companyDto.setCuit(item.getCuit());
      companyDto.setName(item.getName());
      return companyDto;
    }).collect(Collectors.toList());
    
    return companyDtoList;
  }
  
  public List<BaseLocationDto> listAllBaseLocationDto() {
    ModelMapper modelMapper = new ModelMapper();
    List<Location> locationList = repo.findAll();
    List<BaseLocationDto> baseLocationDtoList = locationList.stream()
        .map(item -> modelMapper.map(item, BaseLocationDto.class))
        .collect(Collectors.toList());
    return baseLocationDtoList;
  }

  private Location getLocationFromLocationDto(LocationDto item) {
    Location location = new Location();
    location.setAddress(item.getAddress());
    location.setCity(item.getCity());
    location.setProvince(item.getProvince());
    location.setCountry(item.getCountry());
    location.setPostalCode(item.getPostalCode());
    location.setName(item.getName());
    location.setObs(item.getObs());
    
    return location;
  }

}
