package com.collaboration.test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.collaboration.DAO.UserDAO;
import com.collaboration.DbConfig.DbConfig;
import com.collaboration.model.UserDetail;



@ComponentScan("com.collaboration")
public class UserDetailTest {

static UserDAO  userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.collaboration");
		context.refresh();

		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	public void addUserTest()
	{
		UserDetail user=new UserDetail();
		user.setUserId(15);
		user.setFirstName("srwaehtuhla");
		user.setLastName("rest");
		user.setEmailId("sr@gmail.com");
		user.setPassword("9195");
		user.setRole("Admin");
		user.setStatus("available");
		user.setIsOnline("Y");
		assertTrue("Problem in Inserting user", userDAO.addUserDetail(user));

	}
   @Ignore
	@Test
	public void getAllUserTest(){
		List<UserDetail> userList=(List<UserDetail>)userDAO.getAllUserDetails();
		assertNotNull("Job list not found ",userList.get(0));
		for(UserDetail user:userList)
		{
			System.out.println("EmailID:"+ user.getEmailId() + "Status:"+ user.getStatus());
		}
		

	}
	
}