package com.order.app.exceptions;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bryan.bernabe on 3/29/2017.
 */
public class BaseRuntimeException extends RuntimeException implements Serializable{
  private final List<String> errorCodes;

  public BaseRuntimeException(List<String> errorCodes) {
    this.errorCodes = errorCodes;
  }

  public List<String> getErrorCodes() {
    return errorCodes;
  }
}
