package com.webservices.webservice.exceptions;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {

   @ExceptionHandler(ResourceNotFoundException.class)
   public ResponseEntity<StandardErrorException> resourceNotFound(ResourceNotFoundException rnfe, HttpServletRequest req){
      String error = "Resource not found!";
      HttpStatus status = HttpStatus.NOT_FOUND;
      StandardErrorException standardErr = new StandardErrorException(Instant.now(), status.value(), error, rnfe.getMessage(), req.getRequestURI());

      return ResponseEntity.status(status).body(standardErr);
   }

   @ExceptionHandler(DatabaseException.class)
   public ResponseEntity<StandardErrorException> dbException(DatabaseException e, HttpServletRequest req){
      String error = "Database error!";
      HttpStatus status = HttpStatus.BAD_REQUEST;
      StandardErrorException standardErr = new StandardErrorException(Instant.now(), status.value(), error, e.getMessage(), req.getRequestURI());

      return ResponseEntity.status(status).body(standardErr);
   }
}
