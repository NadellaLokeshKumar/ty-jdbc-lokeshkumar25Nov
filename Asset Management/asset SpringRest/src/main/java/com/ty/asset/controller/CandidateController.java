package com.ty.asset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ty.asset.dto.CandidateBean;
import com.ty.asset.dto.CandidateResponse;
import com.ty.asset.service.CandidateService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class CandidateController {

	@Autowired
	private CandidateService service;

	@PostMapping(path="/add", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)  
	public CandidateResponse addCandidate(@RequestBody CandidateBean bean) {
		CandidateResponse response = new CandidateResponse();
		if(service.addCandidate(bean)) {
			response.setStatusCode(201);               
			response.setMessage("success");
			response.setDescription("Candidate added to DB");
			
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure, email is repeated");
			response.setDescription("Candidate not added to DB");
		}
		return response; 
	}
	
	
	@PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)  
	public CandidateResponse login(@RequestBody CandidateBean bean1)  {
		CandidateResponse response = new CandidateResponse();
		CandidateBean bean = service.login(bean1.getEmail(), bean1.getPassword());
		if(bean != null) {
			response.setStatusCode(201);               
			response.setMessage("success");
			response.setDescription("You have logged in");
			response.setCandidate(bean);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Error to logged in");
		}
		return response;      
	}
	
}
