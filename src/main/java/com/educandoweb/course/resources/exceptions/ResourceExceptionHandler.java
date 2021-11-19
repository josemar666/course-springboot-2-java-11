package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.DataBaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
    
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNoFound(ResourceNotFoundException e , HttpServletRequest request){
	 String error = " resources not found";
	 HttpStatus status = HttpStatus.NOT_FOUND;
	 StandarError err = new StandarError(Instant.now(),status.value(), error,e.getMessage(), request.getRequestURI());
	return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandarError> dataBase (DataBaseException e , HttpServletRequest request){
	 String error = " Data Base Error";
	 HttpStatus status = HttpStatus.BAD_REQUEST;
	 StandarError err = new StandarError(Instant.now(),status.value(), error,e.getMessage(), request.getRequestURI());
	return ResponseEntity.status(status).body(err);
		
	}
	
	
}
