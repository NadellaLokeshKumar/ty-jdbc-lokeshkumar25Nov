package com.ty.asset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.asset.dto.Appartments;
import com.ty.asset.dto.CandidateBean;
import com.ty.asset.dto.CandidateResponse;
import com.ty.asset.dto.Flats;
import com.ty.asset.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminController {

	@Autowired
	private AdminService service;

	@PostMapping(path="/add-ass", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)  
	public CandidateResponse addAsset(@RequestBody Appartments bean) {
		CandidateResponse response = new CandidateResponse();
		if(service.addAsset(bean)) {
			response.setStatusCode(201);               
			response.setMessage("success");
			response.setDescription("Asset added to DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Asset not added to DB");
		}
		return response;      
	}

	@PutMapping(path="/modify", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse modifyAsset(@RequestBody Appartments bean) {
		CandidateResponse response = new CandidateResponse();
		if(service.modifyAsset(bean)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Asset modified in DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Asset not modified in DB");
		}
		return response;
	}
	
	@PostMapping(path="/addcan", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)  
	public CandidateResponse addCandidate(@RequestBody CandidateBean bean) {
		CandidateResponse response = new CandidateResponse();
		if(service.addCandidate(bean)) {
			response.setStatusCode(201);               
			response.setMessage("success");
			response.setDescription("Candidate added to DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Candidate not added to DB");
		}
		return response;      
	}
	
	@DeleteMapping(path="/remove-can/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse deleteCandidate(@PathVariable("id") int id) {
		
		CandidateResponse response = new CandidateResponse();
		if(service.removeCandidate(id)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Candidate deleted form DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Candidate not deleted from DB");
		}
		return response;
	}
	
	@DeleteMapping(path="/remove-ass/{appartmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse deleteAsset(@PathVariable("appartmentId") int appartmentId) {
		
		CandidateResponse response = new CandidateResponse();
		if(service.removeAsset(appartmentId)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Asset deleted form DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Asset not deleted from DB");
		}
		return response;
	}
	
	@GetMapping(path="/get-all-ass", produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse getAllappartments(){
		CandidateResponse response = new CandidateResponse();
		List<Appartments> appartments = service.getAll();
		if(!appartments.isEmpty()) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription(" Appartments in DB");
			response.setAppartments(appartments);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not founded in DB");
		}
		return response;
	}
	
	@GetMapping(path="/get-all-can", produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse getAllCandidates(){
		CandidateResponse response = new CandidateResponse();
		List<CandidateBean> candidates = service.getAllCan();
		if(!candidates.isEmpty()) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Candidates in DB");
			response.setCandidates(candidates);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not founded in DB");
		}
		return response;
	}
	
//	@GetMapping(path="/get-all-flats", produces = MediaType.APPLICATION_JSON_VALUE)
//	public CandidateResponse getAllFlats(){
//		CandidateResponse response = new CandidateResponse();
//		List<Flats> flats = service.getAllFlats();
//		if(!flats.isEmpty()) {
//			response.setStatusCode(201);              
//			response.setMessage("success");
//			response.setDescription("Candidates in DB");
//			response.setFlats(flats);
//		}else {
//			response.setStatusCode(401);
//			response.setMessage("Failure");
//			response.setDescription("Data not founded in DB");
//		}
//		return response;
//	}
	
	@PostMapping(path="/book-flat",produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse bookFlat(@RequestBody Flats flat){
		CandidateResponse response = new CandidateResponse();
		if(service.bookFlat(flat)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Requested for flat");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Not requested");
		}
		return response;
	}
	
	@GetMapping(path="/request",
					produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse request() {
		CandidateResponse response = new CandidateResponse();
		List<Flats> flats = service.requests();
		if(!flats.isEmpty()) {
		response.setStatusCode(201);              
		response.setMessage("success");
		response.setDescription("flats for request");
		response.setFlats(flats);;
	}else {
		response.setStatusCode(401);
		response.setMessage("Failure");
		response.setDescription("Not requested");
	}
		return response;
}
	
	@PostMapping(path="/approve", consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse approve(@RequestBody Flats flat) {
		CandidateResponse response = new CandidateResponse();
		if(service.approve(flat)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Approved");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("not Approved");
	}
		return response;
}
	
	@PostMapping(path="/reject", produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse reject(@RequestBody Flats flat) {
		CandidateResponse response = new CandidateResponse();
		if(service.reject(flat)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Rejected");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("not Rejected");
	}
		return response;
}
	@PostMapping(path="/seereq",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public CandidateResponse seeReq(@RequestBody Flats flat) {
		CandidateResponse response = new CandidateResponse();
		Flats flatA = service.seeReq(flat);
		if(flatA!= null) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("see Status");
			response.setFlat(flatA);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Status");
	}
		return response;
}
}












