package com.wipro.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.wipro.Person;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("/register")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		
		Person person=new Person();
		person.setAdharId(Long.parseLong(request.getParameter("adharId")));
		
		person.setName(request.getParameter("name"));
		person.setAddress(request.getParameter("address"));
		person.setMobile(Long.parseLong(request.getParameter("mobile")));
		request.setAttribute("person", person);
		
		request.getRequestDispatcher("/WEB-INF/views/person.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
