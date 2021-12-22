package com.greenqbit.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.greenqbit.dao.EmployeeDao;
import com.greenqbit.dao.EmployeeDaoImpl;
import com.greenqbit.dao.UserDao;
import com.greenqbit.dao.UserDaoImpl;
import com.greenqbit.model.Employee;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private UserDao user = new UserDaoImpl();
	private EmployeeDao employeeDao = new EmployeeDaoImpl();

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(user.validateUser(request.getParameter("email"), request.getParameter("password"))) {
			try {
				List<Employee> employees = employeeDao.getAllEmployees();
				
				request.setAttribute("employees", employees);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			doGet(request,response);
		}
	}

}
