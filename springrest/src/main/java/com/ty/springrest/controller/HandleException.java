package com.ty.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.springrest.dto.EmployeeResponse;

@RestControllerAdvice              
public class HandleException {
	
	@ExceptionHandler(Exception.class)   // here we can give specified exceptions also like SQLException.class etc.
	public EmployeeResponse getException() {
		EmployeeResponse response = new EmployeeResponse();
		response.setStatusCode(501);
		response.setMessage("Error in code");
		response.setDescription("Got an Exception");
		return response;
	}
}
