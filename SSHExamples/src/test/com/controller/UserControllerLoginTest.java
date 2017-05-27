package test.com.controller;

import javax.persistence.NoResultException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
@WebAppConfiguration("WebContent") // web项目的根目录，默认为 file:src/main/webapp
public class UserControllerLoginTest {
	@Autowired
	private UserService userService;
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private MockHttpSession session;
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	// @Before
	public void setUpSession() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		RequestBuilder builder = MockMvcRequestBuilders.post("/login").param("username", "1").param("password", "111");
		// 执行
		ResultActions resultActions = mockMvc.perform(builder).andDo(MockMvcResultHandlers.print());
		// MockMvcResultHandlers提供结果处理功能
		// MockMvcResultMatchers提供断言功能
		// .andExpect(MockMvcResultMatchers.status().isOk()
		MvcResult result = resultActions.andReturn();
		session = (MockHttpSession) result.getRequest().getSession();
	}

	@Test
	public void login() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		RequestBuilder builder = MockMvcRequestBuilders.post("/login")
				.param("username", "BO").param("password", "1234");
		// 执行
		ResultActions resultActions = mockMvc.perform(builder)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.redirectedUrl("/index"));
		MvcResult result = resultActions.andReturn();
	}
}
