package com.collaboration.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaboration.DAO.BlogDAO;
import com.collaboration.DbConfig.DbConfig;
import com.collaboration.model.Blog;


public class BlogTest 
	{
		 @Autowired
		 private static BlogDAO blogDAO;
		
		 	@SuppressWarnings("resource")
			@BeforeClass
			public static void initialize()
			{
			  	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
				context.register(DbConfig.class);
				context.scan("com.collaboration.*");
				context.refresh();
				
				blogDAO=(BlogDAO)context.getBean("blogDAO");
			}
		 	
		 	 @Ignore
		 	@Test
		 	public void addBlogTest()
		 	{
				Blog blog=new Blog();
			    blog.setBlogId(10);
				blog.setBlogName("advance java");
				blog.setBlogContent("core java");
				blog.setUsername("Rahul");
				blog.setStatus("p");
				blog.setLikes(12);
				blog.setCreateDate(new java.util.Date());
				
				assertTrue("Problem in Inserting Blog",blogDAO.addBlog(blog));
		 	}
	
		 	 @Ignore      
          @Test
          public void updateBlogTest()
          {
         Blog blog=(Blog)blogDAO.getBlog(10);
         blog.setBlogName("core java");
         blog.setBlogContent("standlone application");
         assertTrue("Problem in updating Blog",blogDAO.updateBlog(blog));
 	}
	

  @Ignore
    @Test
      public void deleteBlogTest(){
	Blog blog=(Blog)blogDAO.getBlog(100);
	assertTrue("Problem in deletion",blogDAO.deleteBlog(blog));
}
    
    @Ignore
    @Test
public void approveBlogTest(){
	Blog blog=(Blog)blogDAO.getBlog(2);
	assertTrue("Problem in approving",blogDAO.approveBlog(blog));
}
   
@Test
public void getAllBlogTest(){
	List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
	assertNotNull("Blog list not found ",blogList.get(0));
	for(Blog blog:blogList)
	{
		System.out.println("BlogID:"+blog.getBlogId() + "BlogName:"+blog.getBlogName());
	}

	
}
	}



