package org.binmon.demo.jpa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
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
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {
	
	@InjectMocks
	DepartmentService deptServ = new DepartmentService();
	
	@Spy
	DepartmentRepository deptRepoStubSpy;
	
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
		when(deptRepoStub.findAll()).thenReturn(Arrays.asList(new Dept("11", "History", "Guha"), new Dept("12", "Physics", "Bhaba")));
		deptRepoStub.saveAll(Arrays.asList(new Dept("11", "History", "Guha"), new Dept("12", "Physics", "Physics")));
		assertTrue(deptServ.getDepartments().size()==2);

		deptServ.addDepartment(new Dept("11", "History", "Guha"));		
		ArgumentCaptor<Dept> arg = ArgumentCaptor.forClass(Dept.class);
		verify(deptRepoStub).save(arg.capture());
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
