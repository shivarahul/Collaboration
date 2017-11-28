package com.collaboration.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.collaboration.model.UserDetail;

@Repository("UserDAO")
public class UserDAOImpl implements UserDAO{

	
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addUserDetail(UserDetail user) {
		Session session=sessionFactory.openSession();
		session.flush();
		session.close();
          try	
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
			}
			catch(Exception e)
			{
			System.out.println("Exception occured:" +e);
			return false;
			}	
		}

	


	
	@Transactional
	public boolean updateOnlineStatus(String status, UserDetail user) {
		try
		{
			user.setIsOnline(status);
		sessionFactory.getCurrentSession().save(user);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception occured:" +e);
		return false;
		}	
	}


	@Transactional
	public List<UserDetail> getAllUserDetails() {
		Session session=sessionFactory.openSession();
		 List<UserDetail> user=(List<UserDetail>)session.createQuery("from UserDetail").list();
			session.close();
			return user;
	}

@Transactional
	public UserDetail getUserDetails(String username) {
	Session session=sessionFactory.openSession();
	UserDetail user=(UserDetail)session.get(UserDetail.class,username);
	session.close();
	return user;
}

}
