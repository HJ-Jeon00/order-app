package com.order.app.exceptions;

import java.util.List;

/**
 * Created by bryan.bernabe on 3/29/2017.
 */
public class NoDataFoundException extends BaseRuntimeException{
  public NoDataFoundException(List<String> errorCodes) {
    super(errorCodes);
  }
}
