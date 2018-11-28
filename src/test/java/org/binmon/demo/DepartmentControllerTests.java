package org.binmon.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.binmon.demo.jpa.domain.Dept;
import org.binmon.demo.jpa.service.DepartmentService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DepartmentService mockDepartmentService;

	@Before
	public void init() {

	}

	@After
	public void clear() {

	}

	@Test
	public void getAllDept_Test() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dept/list").header("myHeader", "true").accept(MediaType.APPLICATION_JSON);	
		List<Dept> departments = new ArrayList<Dept>(Arrays.asList(
				new Dept("1", "Maths", "Bhaumik"),
				new Dept("2", "Physics", "Sen"),
				new Dept("Hi", "Physics", "Sen"),
				new Dept("3", "French", "Mance")
			));
		when(mockDepartmentService.getDepartments()).thenReturn(departments);
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
		String expected = "[{deptId:\"1\", deptName:Maths, deptHead:Bhaumik},{deptId:\"2\", deptName:Physics, deptHead:Sen},{deptId:\"Hi\",deptName:Physics,deptHead:Sen},{deptId:\"3\", deptName:French, deptHead:Mance}]";
		JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),true);	
	}

}
