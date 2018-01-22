package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.Job;

public class JobDAOImpl  implements JobDAO{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	@Transactional
	public boolean addJob(Job job) {
		try
		{
		sessionFactory.getCurrentSession().save(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}	
	}
@Transactional
	public boolean updateJob(Job job) {
		// TODO Auto-generated method stub
		try
		{
		sessionFactory.getCurrentSession().delete(job);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception arised:"+e);
		return false;
		}		
	}


@Transactional
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		  Session session=sessionFactory.openSession();
			
			@SuppressWarnings("unchecked")
			List<Job> jobList=(List<Job>)session.createQuery("from Job").list();
			session.close();
			return jobList;
	}

@Transactional
	public Job getJob(int jobId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class, jobId);
		session.close();
		return job;
	}


@Transactional
public boolean deleteJob(Job job) {
	try
	{
	sessionFactory.getCurrentSession().delete(job);
	return true;
	}
	catch(Exception e)
	{
	System.out.println("Exception arised:"+e);
	return false;
	}
}
	

}
