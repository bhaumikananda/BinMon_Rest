package org.binmon.demo.jpa.service;

import static org.junit.Assert.assertTrue;

import org.binmon.demo.jpa.stub.DepartmentRepositoryStub;
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
	dptServ.setDepartmentRepository(new DepartmentRepositoryStub());
	assertTrue(dptServ.getDepartments().size()==5);
	}
	


}
