package com.collaboration.DAO;

import java.util.List;

import com.collaboration.model.Blog;

public interface BlogDAO {
	
	public boolean addBlog(Blog blog);

public boolean updateBlog(Blog blog);
	
	public boolean deleteBlog(Blog blog);
	
	public Blog getBlog(int blogId);
	
	public List<Blog> getAllBlogs();
	
	public boolean approveBlog(String status,Blog blog);
	
	public boolean rejectBlog(Blog blog);
	
	public boolean incrementLike(Blog blog);
	
	public List<Blog> getAllBlogs(int userId);
public List<Blog> getAllPendingBlogs();
	
	public List<Blog> getAllApprovedBlog();
}