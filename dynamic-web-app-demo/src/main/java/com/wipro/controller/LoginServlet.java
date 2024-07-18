package com.wipro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * If Http method is GET, the form data is appended to the url and sent to the server in the foll. format:
 * 
 * 				url?querystring
 * 
 *		query string format:
 *				name=value&name=value
 *
 *	Ex.
 *		http://localhost:8081/dynamic-web-app-demo/login?userid=Srini&password=Srini%40123
 *
 *		While sending sensitive data or large amount of data to the server, apply HttP POST/PUT methods
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			String email = request.getParameter("email");
			String password =  request.getParameter("password");
			
			System.out.println(email + "," +password);
			
			out.println("<html><body><h2>Your Credentials:"+ email+","+password+"</h2></body></html>");
			ServletContext context = this.getServletContext();
			out.println("<br><h2>"+context.getInitParameter("database")+"</h2>");
		
		}catch(Exception e) {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,e.getMessage());
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
