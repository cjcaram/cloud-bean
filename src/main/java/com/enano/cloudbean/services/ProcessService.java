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
  private CommodityStockService commodityStockService;

  @Autowired
  private IncomeProcessRepository incomeProcessRepo;

  private ModelMapper modelMapper = new ModelMapper();

  /** Get all Process´s information by Id
   * 
   * @param id the process id
   * @return Process Dto
   */
  public ProcessDto getProcessById(Long id) {
    LOGGER.info("Fetching Process with ID: " + id);
    ProcessDto processDto = new ProcessDto();
    processDto = modelMapper.map(processRepo.getOne(id), ProcessDto.class);
    processDto.setNaturalCommodities(incomeService.getIncomesByProcessId(id));
    processDto.setProcessedCommodities(commodityService.getCommoditiesByProcessId(id));
    return processDto;
  }

  /** Add a new Process to database
   * 
   * @param processDto
   * @return Saved process entity
   */
  @Transactional
  public Process addProcess(ProcessDto processDto) {
    Process process = new Process();
    processDto.setId(null);
    try {
      process = getProcessEntityFromDto(processDto);
      process = processRepo.save(process);
      List<Commodity> commodityList = getCommoditiesFromDto(process.getId(), processDto);

      commodityService.addNewCommodities(commodityList);
      incomeProcessRepo.saveAll(getIncomesProcess(process.getId(), processDto));
      commodityStockService.addNewProcess(process.getId(), processDto);

    } catch (Exception e) {
      LOGGER.error("Error Trying to save process: " + processDto.toString());
      throw e;
    }
    return process;
  }

  private List<Commodity> getCommoditiesFromDto(Long id, ProcessDto processDto) {
    List<Commodity> commoditiesList = new ArrayList<>();
    processDto.getProcessedCommodities().forEach(dto -> {
      Commodity entity = new Commodity();
      entity = modelMapper.map(dto, Commodity.class);
      entity.setProcessId(id);
      entity.setId(dto.getId());
      commoditiesList.add(entity);
    });
    return commoditiesList;
  }

  private List<IncomeProcess> getIncomesProcess(Long id, ProcessDto processDto) {
    List<IncomeProcess> incomeProcessList = new ArrayList<>();
    processDto.getNaturalCommodities().forEach(dto -> {
      IncomeProcess entity = new IncomeProcess(null, dto.getId(), id);
      incomeProcessList.add(entity);
    });
    return incomeProcessList;
  }

  private Process getProcessEntityFromDto(ProcessDto dto) {
    return new Process(dto.getId(), dto.getProcessNumber(), dto.getReferenceName(), dto.getDate(),
        new Date(), dto.getObs());
  }

  public Object editProcess(ProcessDto processDto) {
    // TODO Auto-generated method stub
    return null;
  }

  public List<Process> getBasicProcessList() {
    return processRepo.findAll();
  }

}
