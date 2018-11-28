package org.binmon.demo.jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.repository.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {
	
	@InjectMocks
	DepartmentService departmentService;
	
	@Mock
	DepartmentRepository departmentRepositoryMock;

	
	@Test
	public void test() {
	DepartmentService dptServ = new DepartmentService();
	assertTrue(dptServ.getDepartmentsFromInstance().size()==4);
	}
	
	@Test
	public void testFindAllWithDBMock() {
	when(departmentRepositoryMock.findAll()).thenReturn(new ArrayList<Dept>(Arrays.asList(
			new Dept("1", "Maths", "Bhaumik"),
			new Dept("2", "Physics", "Sen"),
			new Dept("3", "French", "Mance")
		)));
	List<Dept> departments = departmentService.getDepartments();
	assertTrue(departments.get(0).getDeptHead().equals("Bhaumik"));
	}
	
	
	@Test
	public void testMultiCall() {
		List l = mock(List.class);
		when(l.size()).thenReturn(5).thenReturn(16);
		assertTrue(l.size()==5);
		assertTrue(l.size()==16);
	}
	
	@Test
	public void testParameter() {
		List l = mock(List.class);
		when(l.get(0)).thenReturn("This is a test");
		assertTrue(l.get(0).equals("This is a test"));
	}
	
	@Test
	public void testGenericParameter() {
		List l = mock(List.class);
		when(l.get(anyInt())).thenReturn("This is a test");
		assertTrue(l.get(0).equals("This is a test"));
		assertTrue(l.get(99).equals("This is a test"));
	}
	
	@Test
	public void testDelete() {	
		when(departmentRepositoryMock.findAll()).thenReturn(Arrays.asList(new Dept("11", "History", "Guha"), new Dept("12", "Physics", "Bhaba")));
		departmentRepositoryMock.saveAll(Arrays.asList(new Dept("11", "History", "Guha"), new Dept("12", "Physics", "Physics")));
		assertTrue(departmentService.getDepartments().size()==2);

		departmentService.addDepartment(new Dept("11", "History", "Guha"));		
		ArgumentCaptor<Dept> arg = ArgumentCaptor.forClass(Dept.class);
		verify(departmentRepositoryMock).save(arg.capture());
		assertEquals("History", arg.getValue().getDeptName());
	}
	
//	@Test
//	public void spying() {
//
//		ArgumentCaptor<Dept> arg = ArgumentCaptor.forClass(Dept.class);
//		deptServ.addDepartment(new Dept("12", "Physics", "Bhaba"));
//		deptServ.addDepartment(new Dept("11", "History", "Guha"));
//		verify(deptRepoStubSpy).save(arg.capture());
//		assertEquals("History", arg.getValue().getDeptName());
//	}


}
