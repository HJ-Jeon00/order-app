package com.order.app.models;

/**
 * Created by bryan.bernabe on 3/29/2017.
 */
public class Error {

  private String code = null;
  private String message = null;
  private String description = null;
  private String stacktrace = null;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStacktrace() {
    return stacktrace;
  }

  public void setStacktrace(String stacktrace) {
    this.stacktrace = stacktrace;
  }
}
