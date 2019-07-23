package com.enano.cloudbean.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.repositories.IncomeProcessRepository;
import com.enano.cloudbean.repositories.ProcessRepository;
import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.IncomeProcess;
import com.enano.cloudbean.entities.Process;

@Service
public class ProcessService {
  
  private Logger LOGGER = LogManager.getLogger(ProcessService.class);
  
  @Autowired
  private ProcessRepository processRepo;
  
  @Autowired
  private IncomeService incomeService;
  
  @Autowired
  private CommodityService commodityService;
  
  @Autowired
  private IncomeProcessRepository incomeProcessRepo;
  
  private ModelMapper modelMapper = new ModelMapper();
  
  public ProcessDto getProcessById(Long id) {
    LOGGER.info("Fetching Process with ID: " + id );
    ProcessDto processDto = new ProcessDto();
    processDto = modelMapper.map(processRepo.getOne(id), ProcessDto.class);
    processDto.setNaturalCommodities(incomeService.getIncomesByProcessId(id));
    processDto.setProcessedCommodities(commodityService.getCommoditiesByProcessId(id));
    return processDto;
  }

  @Transactional
  public Process save(ProcessDto processDto) {
    Process process = new Process();
    processDto.setId(null);
    try {
      process = getProcessEntityFromDto(processDto);
      process = processRepo.save(process);
      commodityService.addNewCommodities(getCommoditiesFromDto(process.getId(), processDto));
      incomeProcessRepo.saveAll(getIncomesProcess(process.getId(), processDto));
    } catch (Exception e) {
      LOGGER.error("Trying to save process: " + processDto.toString(), e);
      throw e;
    }
    return process;
  }

  private List<Commodity> getCommoditiesFromDto(Long id, ProcessDto processDto) {
    List<Commodity> commoditiesList = new ArrayList<>();
    processDto.getProcessedCommodities().forEach(dto -> {
      Commodity entity =  new Commodity();
      entity = modelMapper.map(dto, Commodity.class);
      entity.setProcessId(id);
      entity.setId(null);
      commoditiesList.add(entity);
    });
    return null;
  }
  
  private List<IncomeProcess> getIncomesProcess(Long id, ProcessDto processDto) {
    List<IncomeProcess> incomeProcessList = new ArrayList<>();
    processDto.getNaturalCommodities().forEach(dto -> {
      IncomeProcess entity = new IncomeProcess(null, dto.getId(), id);
      incomeProcessList.add(entity);
    });
    return null;
  }

  private Process getProcessEntityFromDto(ProcessDto dto) {
    return new Process(dto.getId(), dto.getProcessNumber(), dto.getReferenceName(),
        dto.getDate(), new Date(), dto.getObs());
  }

  public Object addProcess(ProcessDto processDto) {
    // TODO Auto-generated method stub
    return null;
  }

  public Object editProcess(ProcessDto processDto) {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getBasicProcessList() {
    // TODO Auto-generated method stub
    return null;
  }

}
