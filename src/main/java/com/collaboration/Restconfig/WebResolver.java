package com.collaboration.Restconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableWebMvc
@ComponentScan("com.collaboration")
public class WebResolver {
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		  InternalResourceViewResolver internalResourceViewResolver=new InternalResourceViewResolver();
		    internalResourceViewResolver.setPrefix("/WEB-INF/");
		    internalResourceViewResolver.setSuffix(".jsp");
		    System.out.println("Resolver Created");
		    return internalResourceViewResolver;
		}
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getMultipartResolver()
	{
		CommonsMultipartResolver commonResolver=new CommonsMultipartResolver();
		commonResolver.setMaxUploadSize(1000000);
		return commonResolver;
}
}