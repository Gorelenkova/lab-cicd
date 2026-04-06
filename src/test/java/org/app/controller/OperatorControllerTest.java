package org.app.controller;

import net.minidev.json.JSONUtil;
import org.app.dao.OperatorDao;
import org.app.model.Operator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OperatorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private OperatorDao operatorDao;

	@Test
	void testCreateAndGetOperator() throws Exception {

		System.out.println("Start Test");

		Operator operator = new Operator();
		operator.setName("test");
		Operator saved = operatorDao.save(operator);

		mockMvc.perform(get("/operators/" + saved.getId())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("operator" + saved.getId()));
	}
}
