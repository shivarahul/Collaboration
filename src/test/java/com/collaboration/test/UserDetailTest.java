/*package com.collaboration.test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.collaboration.DAO.UserDAO;
import com.collaboration.DbConfig.DbConfig;
import com.collaboration.model.UsersDetails;




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
		UsersDetails user=new UsersDetails();
		user.setUsers_Id(15);
		user.setFirst_Name("srwaehtuhla");
		user.setLast_Name("rest");
		user.setEmail_Id("sr@gmail.com");
		user.setPassword("9195");
		user.setRole("Admin");
		
		
		assertTrue("Problem in Inserting user", userDAO.saveUser(user));

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
	
}*/