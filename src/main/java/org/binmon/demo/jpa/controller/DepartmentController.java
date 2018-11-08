package org.binmon.demo.jpa.controller;

import java.util.List;

import org.binmon.demo.DemoApplication;
import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	@GetMapping("/dept/list")
	public ResponseEntity<List<Dept>> getAllDept(@RequestHeader(value="myHeader") String headerStr) {
		MDC.put("myHeader", headerStr);
		logger.info("this is a info message");
	    logger.warn("this is a warn message");
	    logger.error("this is a error message");
		HttpHeaders headers = new HttpHeaders();
		headers.add("getAllDept", "ReturningListOfDepartments");
		return new ResponseEntity<List<Dept>>(deptService.getDepartments(), headers, HttpStatus.OK);
	}

	@GetMapping("/dept/{id}")
	public ResponseEntity<Dept> getDept(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("getSelectDept", "ReturningParticularDepartment");
		return new ResponseEntity<Dept>(deptService.getDepartment(id), headers, HttpStatus.OK);
	}
	
	@PostMapping("/dept/add")
	public void addDept(@RequestBody Dept dept) {
		deptService.addDepartment(dept);
	}
	
	@PutMapping("/dept/updt")
	public void updateDept(@RequestBody Dept dept) {
		deptService.updateDepartment(dept);
	}
	
	@DeleteMapping("/dept/dlt")
	public ResponseEntity<Dept> deleteDept(@RequestBody Dept dept) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("wer", "See this is so nice");
		if(deptService.deleteDepartment(dept.getDeptId())) {
			System.out.println("For 1");
			System.out.println(headers);
			return new ResponseEntity<Dept>(dept, headers, HttpStatus.OK);
		}
		System.out.println("For 2");
		return new ResponseEntity<Dept>(dept, headers, HttpStatus.OK);
	}

}