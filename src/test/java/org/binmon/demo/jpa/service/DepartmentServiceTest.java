package org.binmon.demo.jpa.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.repository.DepartmentRepository;
import org.junit.Test;

public class DepartmentServiceTest {
	
	@Test
	public void test() {
	DepartmentService dptServ = new DepartmentService();
	assertTrue(dptServ.getDepartmentsFromInstance().size()==4);
	}
	
	@Test
	public void testWithDB() {
	DepartmentService dptServ = new DepartmentService();
	DepartmentRepository deptRepoStub = mock(DepartmentRepository.class);
	when(deptRepoStub.findAll()).thenReturn(new ArrayList<Dept>(Arrays.asList(
			new Dept("1", "Maths", "Bhaumik"),
			new Dept("2", "Physics", "Sen"),
			new Dept("Hi", "Physics", "Sen"),
			new Dept("3", "French", "Mance")
		)));
	dptServ.setDepartmentRepository(deptRepoStub);
	assertTrue(dptServ.getDepartments().size()==4);
	}
	


}
