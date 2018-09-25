package com.metacube.training.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   protected Class<?>[] getRootConfigClasses()
   {
	   return null;
   }

   protected Class<?>[] getServletConfigClasses()
   {
      return new Class[] { MvcWebConfig.class };
   }

   protected String[] getServletMappings()
   {
      return new String[] { "/" };
   }
}