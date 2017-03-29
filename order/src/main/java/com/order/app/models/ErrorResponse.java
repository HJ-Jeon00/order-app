package com.order.app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan.bernabe on 3/29/2017.
 */
public class ErrorResponse {
  private List<Error> errors = new ArrayList<Error>();

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }
}
