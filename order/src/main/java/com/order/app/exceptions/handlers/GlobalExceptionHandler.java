package com.order.app.exceptions.handlers;

import com.order.app.exceptions.BaseRuntimeException;
import com.order.app.exceptions.DatabaseException;
import com.order.app.exceptions.NoDataFoundException;
import com.order.app.exceptions.SystemException;
import com.order.app.models.Error;
import com.order.app.models.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bryan.bernabe on 3/29/2017.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(SystemException.class)
  @ResponseBody
  public ResponseEntity<Object> handleSystemException(SystemException exception) {
    return new ResponseEntity<>(this.generateServiceErrorResponse(exception), HttpStatus
      .INTERNAL_SERVER_ERROR);
  }


  @ExceptionHandler(DatabaseException.class)
  @ResponseBody
  public ResponseEntity<Object> handleSystemException(DatabaseException exception) {
    return new ResponseEntity<>(this.generateServiceErrorResponse(exception), HttpStatus
      .INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(NoDataFoundException.class)
  @ResponseBody
  public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException exception) {
    return new ResponseEntity<>(this.generateErrorResponse(exception), HttpStatus.OK);
  }

  protected ErrorResponse generateServiceErrorResponse(BaseRuntimeException exception) {
    ErrorResponse errorResponse = new ErrorResponse();
    List<Error> errorList;
    List<String> errorCodeList;
    List<String> inputParamList;
    if (exception != null) {
      errorCodeList = exception.getErrorCodes();
      //If input param is not null & empty, the exception is from the api
      if (errorCodeList != null && !errorCodeList.isEmpty()) {
        errorList = new ArrayList<>();
        Error error;
        String errorCode;

        for (int i = 0; i < errorCodeList.size(); i++) {
          errorCode = errorCodeList.get(i);
          error = new Error();
          error.setCode(errorCode);
          //error.setDescription(errorProperties.getDescription(errorCode));
          //error.setMessage(errorProperties.getMessage(errorCode));
          errorList.add(error);
        }
        errorResponse.setErrors(errorList);
      } else {
        return generateErrorResponse(exception);
      }
    }
    return errorResponse;
  }

  protected ErrorResponse generateErrorResponse(BaseRuntimeException exception) {
    ErrorResponse errorResponse = new ErrorResponse();
    List<Error> errorList;
    List<String> errorCodeList;
    if (exception != null) {
      errorCodeList = exception.getErrorCodes();
      if (errorCodeList != null && !errorCodeList.isEmpty()) {
        errorList = new ArrayList<>();
        Error error;
        for (String errorCode : errorCodeList) {
          error = new Error();
          error.setCode(errorCode);
          //error.setDescription(errorProperties.getDescription(errorCode));
          //error.setMessage(errorProperties.getMessage(errorCode));
          errorList.add(error);
        }
        errorResponse.setErrors(errorList);
      }
    }
    return errorResponse;
  }
}
