package com.enano.cloudbean.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.repositories.ProcessRepository;
import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.Process;

@Service
public class ProcessService {

  private Logger LOGGER = LogManager.getLogger(ProcessService.class);

  @Autowired
  private ProcessRepository processRepo;

  @Autowired
  private CommodityStockService commodityStockService;
  
  private ModelMapper modelMapper = new ModelMapper();

  /** Get all Process´s information by Id
   * 
   * @param id the process id
   * @return Process
   */
  public ProcessDto getProcessById(Long id) {
    LOGGER.info("Fetching Process by ID: " + id);
    ProcessDto processDto = new ProcessDto();
    Process process = processRepo.getOne(id);
    processDto = modelMapper.map(process, ProcessDto.class);
    processDto.setNaturalCommodities(CommodityToDto(process.getCommoditiesToProcess()));
    processDto.setProcessedCommodities(CommodityToDto(process.getCommoditiesProcessed()));
    return processDto;
  }
  
  private Set<CommodityDto> CommodityToDto(Set<Commodity> commodities) {
    Set<CommodityDto> commoditiesDto = new HashSet<>();
    for (Commodity commodity : commodities) {
      commoditiesDto.add(modelMapper.map(commodity, CommodityDto.class));
    }
    return commoditiesDto;
  }

  /** Add a new Process to database
   * 
   * @param processDto
   * @return Saved process entity
   */
  @Transactional
  public Process addProcess(ProcessDto processDto) {
    LOGGER.info("[Method: addProcess]");

    Process process = new Process();
    processDto.setId(null);
    try {
      process = getProcessEntityFromDto(processDto);
      process.setCommoditiesToProcess(processDto.getCommoditiesToProcess());
      process.setCommoditiesProcessed(processDto.getCommoditiesProcessed());
      process = processRepo.save(process);
      commodityStockService.addNewProcess(process);
    } catch (Exception e) {
      LOGGER.error("Error Trying to save process: " + processDto.toString());
      throw e;
    }
    return process;
  }
  
  /** Edit Process 
   * 
   * @param processDto
   * @return Edited process entity
   */
  @Transactional
  public Process editProcess(ProcessDto processDto) {
    LOGGER.info("[Method: editProcess]");
    Process processToEdit = processRepo.getOne(processDto.getId());
    Process editedProcess = new Process();
    try {
      processToEdit.setModificationDate(new Date());
      processToEdit.setObs(processDto.getObs());
      processToEdit.setProcessNumber(processDto.getProcessNumber());
      processToEdit.setReferenceName(processDto.getReferenceName());
      processToEdit.setCommoditiesToProcess(processDto.getCommoditiesToProcess());
      processToEdit.setCommoditiesProcessed(processDto.getCommoditiesProcessed());
      editedProcess = processRepo.save(processToEdit);
      commodityStockService.editProcess(editedProcess);
    } catch (Exception e) {
      LOGGER.error("Error Trying to edit process: " + processDto.toString());
      throw e;
    }
    return editedProcess;
  }

  private Process getProcessEntityFromDto(ProcessDto dto) {
    return new Process(dto.getId(), dto.getProcessNumber(), dto.getReferenceName(), dto.getDate(),
        new Date(), dto.getObs());
  }


  public List<Process> getBasicProcessList() {
    return processRepo.findAll();
  }
  
}
