package org.binmon.demo.jpa.controller;

import java.util.List;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService deptService;

	@RequestMapping(method=RequestMethod.GET, value="/dept/list")
	public List<Dept> getDepartments() {
		return deptService.getDepartments();
	}

	@RequestMapping(method=RequestMethod.GET, value="/dept/{id}")
	public Dept getDepartmens(@PathVariable("id") String id) {
		return deptService.getDepartment(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/dept/add")
	public void addDept(@RequestBody Dept dept) {
		deptService.addDepartment(dept);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/dept/updt")
	public void updtDept(@RequestBody Dept dept) {
		deptService.updateDepartment(dept);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/dept/dlt/{deptId}")
	public void updtDept(@PathVariable("deptId") String deptId) {
		deptService.deleteDepartment(deptId);
	}
}