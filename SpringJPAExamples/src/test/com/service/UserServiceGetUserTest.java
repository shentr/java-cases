package test.com.service;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import com.service.UserService;

@RunWith(Parameterized.class)
@ContextConfiguration("classpath:beans.xml")
public class UserServiceGetUserTest {
	@ClassRule
	public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
	@Rule
	public final SpringMethodRule springMethodRule = new SpringMethodRule();
	@Autowired
	private UserService userService;
	
	private int param;
	private String expected;
	public UserServiceGetUserTest(int param, String expected) {
		super();
		this.param = param;
		this.expected = expected;
	}
	@Parameters
	public static Collection<Object[]> setParams() {
		Collection<Object[]> objects = new ArrayList<>();
		objects.add(new Object[] {2, "SUN" });
		objects.add(new Object[] {3, "BO" });
		objects.add(new Object[] {4, "BO" });
		objects.add(new Object[] {5, "BO" });
		objects.add(new Object[] {6, "BO" });
		objects.add(new Object[] {8, "BO" });
		return objects;
	}

	@Test
	public void getUser_params_success() {
		Assert.assertEquals(expected, userService.getUser(param).getName());
	}
}
