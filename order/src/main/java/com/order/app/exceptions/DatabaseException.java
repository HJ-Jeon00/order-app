package com.order.app.exceptions;

import java.util.List;

/**
 * Created by bryan.bernabe on 3/29/2017.
 */
public class DatabaseException extends BaseRuntimeException{
  public DatabaseException(List<String> errorCodes) {
    super(errorCodes);
  }
}
