package com.ty.asset.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.asset.dto.CandidateResponse;

@RestControllerAdvice
public class HandleException {

	@ExceptionHandler(Exception.class)
	public CandidateResponse getException() {
		CandidateResponse response = new CandidateResponse();
		response.setStatusCode(501);
		response.setMessage("Error in code");
		response.setDescription("Got an Exception");
		return response;
		
	}
}
