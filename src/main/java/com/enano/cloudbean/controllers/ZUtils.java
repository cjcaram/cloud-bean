package com.enano.cloudbean.controllers;

import org.springframework.http.ResponseEntity;

import com.enano.cloudbean.dtos.HttpErrorBody;

public class ZUtils {
  public static boolean isEdition(Integer id) {
    return id != null && id > 0;
  }
  
  public static ResponseEntity<?> getErrorResponse(HttpErrorBody httpErrorBody) {
    return new ResponseEntity<>(httpErrorBody.getKnownErros(), httpErrorBody.getHttpStatus());
  }
}
