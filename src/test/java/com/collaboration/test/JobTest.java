package com.collaboration.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.collaboration.DAO.JobDAO;
import com.collaboration.DbConfig.DbConfig;
import com.collaboration.model.Job;


@ComponentScan("com.collaboration")
@Ignore
public class JobTest {

	

static JobDAO jobDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(DbConfig.class);
		context.scan("com.backend");
         context.refresh();
		
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	
	
@Ignore
	@Test
	public void addJobTest(){
		Job job=new Job();
		job.setJobId(16);
		job.setJobProfile("asst.man");
		job.setJobDesc("managing");
		job.setQualification("B.TECH");
		job.setStatus("Eligible");
		job.setPostDate(new java.util.Date());
		
		assertTrue("Problems in Inserting Job",jobDAO.addJob(job));
	}
	//@Ignore
	@Test
	public void getAllJobTest(){
		List<Job> jobList=(List<Job>)jobDAO.getAllJobs();
		assertNotNull("Job list not found ",jobList.get(0));
		for(Job job:jobList)
		{
			System.out.println("JobID:"+ job.getJobId() + "JobProfile:"+ job.getJobProfile());
		}
	}
@Ignore
	@Test
	public void getJobTest(){

		Job job=(Job)jobDAO.getJob(11);
		
		System.out.println("JobProfile:" + job.getJobProfile());
		System.out.println("JobDescription:" + job.getJobDesc());
		
		assertNotNull("Job not found", job);
	}
		
	}

