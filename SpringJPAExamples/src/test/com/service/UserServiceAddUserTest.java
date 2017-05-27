package test.com.service;

import static org.junit.Assert.*;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class UserServiceAddUserTest {
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	@Autowired
	private UserService userService;
	@Test
	public void addUser_null_execption() {
		User user = null;
		// 预期为IllegalArgumentException异常
		expectedException.expect(IllegalArgumentException.class);
		userService.addUser(user);
	}
	@Test
	public void addUser_newuser_success() {
		User user = new User();
		user.setName("BO");
		userService.addUser(user);
	}
	@Test
	@Transactional
	@Rollback(value = false)
	public void addUser_newuser_successbutrollback() {
		User user = new User();
		user.setName("SUN");
		userService.addUser(user);
	}

}
