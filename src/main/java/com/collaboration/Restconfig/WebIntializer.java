package com.collaboration.Restconfig;




public class WebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[]{WebResolver.class};
	}
	
	
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}

	protected String[] getServletMappings()
	{
		return new String[] {"/"};
	}

}


	




