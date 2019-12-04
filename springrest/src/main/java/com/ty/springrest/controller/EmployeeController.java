package com.ty.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springrest.dto.EmployeeBean;
import com.ty.springrest.dto.EmployeeResponse;
import com.ty.springrest.service.EmployeeService;

@RestController             // in spring rest, controller itself gives the response.so, @RestController is used.
public class EmployeeController {

		@Autowired
		private EmployeeService service;
	
	
		@PostMapping(path="/add", consumes = MediaType.APPLICATION_JSON_VALUE,
							produces = MediaType.APPLICATION_JSON_VALUE)  //JSON_VALUE accepts or produces the Json data.
	public EmployeeResponse addEmployee(@RequestBody EmployeeBean bean) {
			EmployeeResponse response = new EmployeeResponse();
			if(service.addEmployee(bean)) {
				response.setStatusCode(201);               //all 200 series are for success. All 400 series are failure.
				response.setMessage("success");
				response.setDescription("Data added to DB");
			}else {
				response.setStatusCode(401);
				response.setMessage("Failure");
				response.setDescription("Data not added to DB");
			}
		return response;                                            // for add and modify methods always use Post,Put mappings.
	}//end of addEmployee
	
	
	@PutMapping(path="/modify", consumes = MediaType.APPLICATION_JSON_VALUE,
								produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(@RequestBody EmployeeBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if(service.modifyEmployee(bean)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Data modified in DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not modified in DB");
		}
		return response;
	}//end of madifyEmployee
	
	
	@DeleteMapping(path="/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id") int id) {
		
		EmployeeResponse response = new EmployeeResponse();
		if(service.deleteEmployee(id)) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Data deleted form DB");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not deleted from DB");
		}
		return response;
	}//end of deleteEmployee
	
	
	@GetMapping(path="/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getEmployee(@RequestParam("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		EmployeeBean bean = service.getEmployee(id);
		if(bean!=null) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Data found in DB");
			response.setEmployeeBeans(Arrays.asList(bean));
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not founded inDB");
		}
		return response;
	}//end of getEmployee
	
	@GetMapping(path="/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee(){
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> beans = service.getAllEmployee();
		if(!beans.isEmpty()) {
			response.setStatusCode(201);              
			response.setMessage("success");
			response.setDescription("Data found in DB");
			response.setEmployeeBeans(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not founded in DB");
		}
		return response;
	}//end of getAllEmployee
	
	
	@GetMapping(path = "/exce", produces = MediaType.APPLICATION_JSON_VALUE)
	public void createException() {
		int i = 1/0;
	}
	
}//end of EmployeeController.
