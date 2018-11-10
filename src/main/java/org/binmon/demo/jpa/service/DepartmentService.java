package org.binmon.demo.jpa.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	private List<Dept> departments = new ArrayList<Dept>(Arrays.asList(
			new Dept("1", "Maths", "Bhaumik"),
			new Dept("2", "Physics", "Sen"),
			new Dept("Hi", "Physics", "Sen"),
			new Dept("3", "French", "Mance")
		));

	public List<Dept> getDepartmentsFromInstance() {
		return departments;
	}
	
	public List<Dept> getDepartments() {
		List<Dept> depts = new ArrayList<>();
		departmentRepository.findAll().forEach(depts::add);
		return depts;
	}
	
	public Dept getDepartment(String id) {
		return departments.stream().filter(t -> t.getDeptId().equals(id)).findFirst().get();
	}

	public void addDepartment(Dept dept) {
		departments.add(dept);
		departmentRepository.save(dept);
	}
	
	public void updateDepartment(Dept dept) {
		Dept updtDept = departments.stream().filter(t -> t.getDeptId().equals(dept.getDeptId())).findFirst().get();
		updtDept.setDeptHead(dept.getDeptHead());
		updtDept.setDeptName(dept.getDeptName());
		if(departmentRepository.findById(dept.getDeptId()).isPresent()) {
			departmentRepository.save(dept);
		}else {
			
		}
			
	}
	
	public boolean deleteDepartment(String deptId) {
		departmentRepository.deleteById(deptId);
		return true;
	}

	public void setDepartmentRepository(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}
}
