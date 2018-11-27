package org.binmon.demo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

	@Before
	public void init() {

	}

	@After
	public void clear() {

	}

	@Test
	public void getAllDept_Test() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dept/list").header("myHeader", "true").accept(MediaType.APPLICATION_JSON);		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(MediaType.APPLICATION_JSON_UTF8.toString(), result.getResponse().getContentType());		
	}

}
