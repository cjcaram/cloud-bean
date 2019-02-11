package com.enano.cloudbean.dtos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class HttpErrorBody {
  private String exceptionErrorMsg;
  private List<String> knownErrors;
  private Exception exeption;
  private HttpStatus httpStatus;
  
  public HttpErrorBody(HttpStatus httpStatus, Exception exeption, List<String> knownErros) {
    this.exceptionErrorMsg = exeption.getMessage();
    this.knownErrors = knownErros;
    this.exeption = exeption;
    this.httpStatus = httpStatus;
  }
  
  public HttpErrorBody(HttpStatus httpStatus, Exception exeption, String knownError) {
    this.exceptionErrorMsg = exeption.getMessage();
    this.knownErrors = new ArrayList<>();
    this.knownErrors.add(knownError);
    this.exeption = exeption;
    this.httpStatus = httpStatus;
  }

  public String getExceptionErrorMsg() {
    return exceptionErrorMsg;
  }

  public List<String> getKnownErros() {
    return knownErrors;
  }

  public void setKnownErros(List<String> knownErros) {
    this.knownErrors = knownErros;
  }

  public Exception getExeption() {
    return exeption;
  }

  public void setExeption(Exception exeption) {
    this.exeption = exeption;
    this.exceptionErrorMsg = exeption.getMessage();
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }
  
  public String toString() {
    return "Http Status Code: " + httpStatus.value() + "\n" +
        "Http Status phrase:" + httpStatus.getReasonPhrase() + "\n" +
        "Error List :" + String.join(", ", knownErrors) + "\n" +
        "Exception Message: " + exceptionErrorMsg;
  }
  

}
