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
import com.greenqbit.model.Employee;

/**
 * Servlet implementation class DeleteEmployeeController
 */
public class DeleteEmployeeController extends HttpServlet {
	EmployeeDao employeeDao = new EmployeeDaoImpl();       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(!id.equals("new")) {
			try {
				employeeDao.delete(Long.parseLong(id));
				
					List<Employee> employees = employeeDao.getAllEmployees();
				
				request.setAttribute("employees", employees);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
				e.printStackTrace();
			}
			
		}else {
			response.sendRedirect(request.getContextPath() +"/edit.jsp");			
		}
	}

	
}
