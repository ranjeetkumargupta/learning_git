package com.wipro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * http://localhost:8081/dynamic-web-app-demo/hello
 * 
 * Since default HTTP method is GET, control enters into gdoGet() method
 * 
 *    HttpServlet -> GenericServlet -----> Servlet
 *    
 *    Servlet is an interface, GenericServlet is a class that implements Servlet,
 *    HttpServlet is class that extends GenericServlet.
 *    
 *    
 *    GenericServlet can handle any type of protocol( Http, ftp, SMTP etc) whereas HttpServlet
 *    can handle only Http protocol. Since most of the web applications are http-base, we create our own
 *    servlet that extend HttpServlet.
 *    
 */

@WebServlet(urlPatterns= "/hello" , 
			initParams = {
							@WebInitParam(name = "user", value = "Srini"),
							@WebInitParam(name = "job", value = "Trainer")
						}
			)
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//dynamically generate the web page, writes into response object
		out.println("<html><body><h1><font color='red'> Welcome to My Dynamic Page</font></h1></body></html>");
		
		//getting reference to ServletConfig object of HelloWorldServlet instance
		ServletConfig config = this.getServletConfig();
		//ServletConfig object contains initialization values of the servlet
		out.println(config.getInitParameter("user"));
		out.println(config.getInitParameter("job"));
		
		ServletContext context = this.getServletContext();
		out.println("<br><h2>"+context.getInitParameter("database")+"</h2>");
		
		out.println("<br><h2>"+context.getAttribute("college")+"</h2>");
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
