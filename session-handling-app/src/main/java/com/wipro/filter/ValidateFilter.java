package com.wipro.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(filterName = "filter1",urlPatterns="/controller")
public class ValidateFilter extends HttpFilter implements Filter {
       
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("request object entered into validateFilter");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("response object exiting into validateFilter");
		
	}

}
