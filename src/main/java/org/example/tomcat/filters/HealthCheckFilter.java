package org.example.tomcat.filters;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RequestLoggingFilter
 */
@WebFilter("/HealthCheckFilter")
public class HealthCheckFilter implements Filter {
	
	private ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("HealthCheckFilter initialized");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
        HttpServletResponse servletResponse = (HttpServletResponse) response;

		this.context.log("HealthCheckFilter doFilter");
		servletResponse.setContentType("text/html");
        servletResponse.setStatus(200);
	}

	public void destroy() {

	}
}