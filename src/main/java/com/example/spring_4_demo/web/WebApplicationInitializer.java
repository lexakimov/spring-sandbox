package com.example.spring_4_demo.web;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * It replacement of web.xml
 *
 * @author akimov
 * created at 25.11.2020 19:57
 */
public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();

		root.scan("com.example.spring_4_demo.configuration");
		servletContext.addListener(new ContextLoaderListener(root));

		GenericWebApplicationContext applicationContext = new GenericWebApplicationContext();
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
		ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc", dispatcherServlet);
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
}
