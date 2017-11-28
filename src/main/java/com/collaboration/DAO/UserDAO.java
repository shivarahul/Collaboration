package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.UserDetail;



public interface UserDAO {


	public boolean addUserDetail(UserDetail user);
	public boolean updateOnlineStatus(String status, UserDetail user);

	public List<UserDetail> getAllUserDetails();
	public UserDetail getUserDetails(String username);
	
	
	
}
