package com.slytherin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slytherin.view.managed.LoginBean;

public class AuthenticationFilter implements Filter {
	  
	@SuppressWarnings("unused")
	private FilterConfig config;

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
    
		String uri = ((HttpServletRequest) req).getRequestURI();
		
		if (((HttpServletRequest) req).getSession().getAttribute(LoginBean.AUTH_KEY) == null && !excludeFromFilter(uri)) {
			((HttpServletResponse) resp).sendRedirect("deny");
		} else {
			chain.doFilter(req, resp);
    	}
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}
	
	private boolean excludeFromFilter(String uri) {
	      if (uri.indexOf("home.xhtml") > -1 
	    		  || uri.indexOf("javax.faces.resource") > -1
	    		  || uri.endsWith(".css")
	    		  || uri.endsWith(".js")
	    		  || uri.endsWith(".gif")
	    		  || uri.endsWith(".jpg")
	    		  || uri.endsWith(".png")){
	    	  return true; 
	      }
	      else return false;
	   }
}
