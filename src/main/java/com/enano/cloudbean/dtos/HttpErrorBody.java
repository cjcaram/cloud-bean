package com.enano.cloudbean.dtos;

import java.util.List;

import org.springframework.http.HttpStatus;

public class HttpErrorBody {
  private String exceptionErrorMsg;
  private List<String> knownErros;
  private Exception exeption;
  private HttpStatus httpStatus;
  
  public HttpErrorBody(HttpStatus httpStatus, Exception exeption, List<String> knownErros) {
    this.exceptionErrorMsg = exeption.getMessage();
    this.knownErros = knownErros;
    this.exeption = exeption;
    this.httpStatus = httpStatus;
  }
  
  public HttpErrorBody(HttpStatus httpStatus, Exception exeption, String knownErro) {
    this.exceptionErrorMsg = exeption.getMessage();
    this.knownErros.add(knownErro);
    this.exeption = exeption;
    this.httpStatus = httpStatus;
  }

  public String getExceptionErrorMsg() {
    return exceptionErrorMsg;
  }

  public List<String> getKnownErros() {
    return knownErros;
  }

  public void setKnownErros(List<String> knownErros) {
    this.knownErros = knownErros;
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
        "Error List :" + String.join(", ", knownErros) + "\n" +
        "Exception Message: " + exceptionErrorMsg;
  }
  

}
