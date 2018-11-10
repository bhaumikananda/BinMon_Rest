package org.binmon.demo.jpa.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.repository.DepartmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {
	
	@InjectMocks
	DepartmentService deptServ = new DepartmentService();
	
	@Mock
	DepartmentRepository deptRepoStub;

	
	@Test
	public void test() {
	DepartmentService dptServ = new DepartmentService();
	assertTrue(dptServ.getDepartmentsFromInstance().size()==4);
	}
	
	@Test
	public void testFindallWithDB() {
	when(deptRepoStub.findAll()).thenReturn(new ArrayList<Dept>(Arrays.asList(
			new Dept("1", "Maths", "Bhaumik"),
			new Dept("2", "Physics", "Sen"),
			new Dept("Hi", "Physics", "Sen"),
			new Dept("3", "French", "Mance")
		)));
	
	assertTrue(deptServ.getDepartments().size()==4);
	}
	
	
	@Test
	public void testDelete() {
		
		Dept d1 = new Dept();
		d1.setDeptId("1");
		d1.setDeptName("History");
		d1.setDeptHead("Guha");
		Dept d2 = new Dept();
		d2.setDeptId("2");
		d2.setDeptName("Physics");
		d2.setDeptHead("Bhaba");
		
		when(deptRepoStub.findAll()).thenReturn(Arrays.asList(d1, d2));
		deptRepoStub.saveAll(Arrays.asList(d1, d2));
//		when(deptServ.deleteDepartment("1")).then(new Answer);
		deptServ.deleteDepartment("1");
		assertTrue(deptServ.getDepartments().size()==2);
	}


}
