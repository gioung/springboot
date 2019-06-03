package com.cafe24.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
@PropertySource("classpath:com/cafe24/config/web/properties/multipart.properties")
public class FileuploadConfig implements WebMvcConfigurer  {

	@Autowired
	private Environment env;
	//
	//MultiPart Resolver
	//
	
	@Bean
	
	public CommonsMultipartResolver multipartResolver() {
		
		
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(env.getProperty("maxUploadSize",Long.class));
		commonsMultipartResolver.setMaxInMemorySize(env.getProperty("maxInMemorySize",Integer.class));
		commonsMultipartResolver.setDefaultEncoding(env.getProperty("defaultEncoding"));
		
		return commonsMultipartResolver;
	}
	
	@Override
	//가상 url mapping 해주는 놈
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("file:/mysite-uploads/");
		
	}
	
}
