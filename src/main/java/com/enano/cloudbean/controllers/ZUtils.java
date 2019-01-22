package com.enano.cloudbean.controllers;

public class ZUtils {
  
  public static final String REMOVING_ENTITY_MSG = "Removing Entity.";
  public static final String DEPENDENCIES_FOUNDS_MSG = "Dependencies Founds.";
  public static final String CHECKING_DEPENDENCIES_MSG = "Checking dependencies.";
  public static final String ENTITY_REMOVED_MSG = "Entity deleted.";
  public static final String FETCHING_ENTITIES_MSG = "Fetching all entities.";
  public static final String FETCHING_ENTITY_MSG = "Fetching entity.";
  public static final String ADDING_ENTITY_MSG = "Adding entity.";
  public static final String EDITING_ENTITY_MSG = "Editing entity.";
  public static final String ERROR_FETCHING_ENTITY_MSG = "There was an error trying to fetching the entity.";
  public static final String ERROR_REMOVING_ENTITY_MSG = "There was an error trying to remove the entity.";
  public static final String ERROR_FETCHING_ENTITIES_MSG = "There was an error trying to fetch all entities.";
  public static final String ERROR_ADD_EDIT_ENTITY_MSG = "Error adding or updating entity";
  public static final String BASE_LIST_PART_MSG = "(base-list)";
  public static final String BASIC_LIST_PART_MSG = "(basic-list)";
  public static final String CREATING_REPORT_MSG = "Creating Report.";
  public static final String ERROR_CREATING_REPORT_MSG = "There was an error generating Report.";
  
  public static boolean isEdition(Integer id) {
    return id != null && id > 0;
  }
  
  public static boolean isEdition(Long id) {
    return id != null && id > 0;
  }
}
