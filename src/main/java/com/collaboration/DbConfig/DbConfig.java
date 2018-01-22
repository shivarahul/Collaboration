package com.collaboration.DbConfig;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.collaboration.DAO.BlogDAO;
import com.collaboration.DAO.BlogDAOImpl;
import com.collaboration.DAO.ForumDAO;
import com.collaboration.DAO.ForumDAOImpl;
import com.collaboration.DAO.JobDAO;
import com.collaboration.DAO.JobDAOImpl;
import com.collaboration.DAO.ProfilePictureDAO;
import com.collaboration.DAO.ProfilePictureDAOImpl;
import com.collaboration.DAO.UserDAO;
import com.collaboration.DAO.UserDAOImpl;
import com.collaboration.model.Blog;

import com.collaboration.model.Forum;
import com.collaboration.model.Friend;
import com.collaboration.model.Job;
import com.collaboration.model.ProfilePicture;
import com.collaboration.model.UsersDetails;




@Configuration
@EnableTransactionManagement
@ComponentScan("com.collaboration")
@Component
@EnableWebMvc
public class DbConfig 
{	
	@Bean(name = "dataSource")
	public DataSource getOracleDataSource()
	{
		DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		driverManagerDataSource.setUsername("RAH");
		driverManagerDataSource.setPassword("rah");
		return driverManagerDataSource;
	}
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		return properties;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory()
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(UsersDetails.class);
		localSessionFactoryBuilder.addAnnotatedClass(Job.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		localSessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
			
		localSessionFactoryBuilder.scanPackages("com.collaboration");
		System.out.println("SessionFactory Bean Created");
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}
	

	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
		System.out.println("User DAO object Created");
		return new UserDAOImpl(sessionFactory);
}

	
	
	
	
	@Autowired
	@Bean(name = "forumDAO")
	public ForumDAO getForumDAO(SessionFactory sessionFactory)
	{
		System.out.println("Forum DAO object Created");
		return new ForumDAOImpl(sessionFactory);
}
	

	@Autowired
	@Bean(name="blogDAO")
	public BlogDAO getBlogDAO(SessionFactory sessionFactory)
	{
		System.out.println("Blog DAO object Created");
		return new BlogDAOImpl(sessionFactory);
	
	}
	
	
	@Autowired
	@Bean(name="jobDAO")
	public JobDAO getJobDAO(SessionFactory sessionFactory)
	{
		System.out.println("Job DAO object Created");
		return (JobDAO) new JobDAOImpl(sessionFactory);
}
	
	@Autowired
	@Bean(name="profilePictureDAO")

	public ProfilePictureDAO getProfilePictureDAO(SessionFactory sessionFactory) {
		System.out.println("ProfilePicture DAO object Created");
		return new ProfilePictureDAOImpl(sessionFactory);
	
}
}