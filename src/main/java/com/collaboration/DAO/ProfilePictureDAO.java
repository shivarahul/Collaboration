package com.collaboration.DAO;

import com.collaboration.model.ProfilePicture;

public interface ProfilePictureDAO {

	
	public ProfilePicture getProfilePicture(String username);
	public void saveProfilePicture(ProfilePicture profilePicture);
}
