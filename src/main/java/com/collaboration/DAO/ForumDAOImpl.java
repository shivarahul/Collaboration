package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.collaboration.model.Forum;

public class ForumDAOImpl implements ForumDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	ForumDAO forumDAO;
	
	public ForumDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public boolean addForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().save(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	
		
	}

	@Transactional
	public boolean updateForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().delete(forum);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:"+e);
		return false;
		}	
	}

	public Forum getForum(int ForumId) {
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class, ForumId);
		session.close();
		return forum;
	}

	public List<Forum> getAllForums() {
		 Session session=sessionFactory.openSession();
			
			List<Forum> forumList=(List<Forum>)session.createQuery("from Forum").list();
			session.close();
			return forumList;
		}

		
		@Transactional
	public boolean approveForum(String status, Forum forum) {
			try{
			       forum.setStatus(status);
						sessionFactory.getCurrentSession().saveOrUpdate(forum);
						return true;
						}
						catch(Exception e)
						{
						System.out.println("Exception occured:"+e);
						return false;
						}	
					}
		
		@Transactional
	public boolean rejectForum(Forum forum) {
		try{
			forum.setStatus("N");
			sessionFactory.getCurrentSession().update(forum);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:"+e);
			return false;
			}	
	}

	}


