package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.UsersDetails;

public interface UserDAO {


	//public boolean addUserDetail(UsersDetails user);
	public boolean updateOnlineStatus(String status, UsersDetails user);
	public UsersDetails getByEmail(String email);
/*	public List<UsersDetails> getAllUserDetails();
*/	public UsersDetails getUserDetails(String username);
	public boolean checkLogin(String username, String password);
	public List<UsersDetails> getAllUserDetails();
	public boolean addUserDetail(UsersDetails userDetail);

}
