package com.greenqbit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.greenqbit.dao.UserDao;
import com.greenqbit.dao.UserDaoImpl;
import com.greenqbit.model.User;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {

	private User registration = new User();
	private UserDao user = new UserDaoImpl();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			registration.setFirstName(request.getParameter("firstName"));
			registration.setLastName(request.getParameter("lastName"));
			registration.setEmail(request.getParameter("email"));
			registration.setPassword(request.getParameter("password"));
			registration.setAddressline1(request.getParameter("addressLine1"));
			registration.setAddressline2(request.getParameter("addressLine2"));
			registration.setCity(request.getParameter("city"));
			registration.setState(request.getParameter("state"));
			registration.setZip(request.getParameter("zip"));
			
			user.registration(registration);
			
			
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
	}
}
