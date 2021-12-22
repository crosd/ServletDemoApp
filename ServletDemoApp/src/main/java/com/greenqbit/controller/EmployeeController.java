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


public class EmployeeController extends HttpServlet {
	EmployeeDao employeeDao = new EmployeeDaoImpl();
	Employee employee = new Employee();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(!id.equals("new")) {
			try {
				Employee employee= employeeDao.getEmployee(Long.parseLong(id));
				
				request.setAttribute("employee", employee);
				RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			response.sendRedirect(request.getContextPath() +"/edit.jsp");			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			employee.setName(request.getParameter("name"));
			employee.setPosition(request.getParameter("position"));
			employee.setCompany(request.getParameter("company"));
			employee.setDepartment(request.getParameter("department"));
			if((request.getParameter("id")).isBlank()) {
				employeeDao.saveEmployee(employee);
			}else {
				employee.setId(Long.parseLong(request.getParameter("id")));
				employeeDao.updateEmployee(employee);
			}
			
			
			
			List<Employee> employees = employeeDao.getAllEmployees();
			
			request.setAttribute("employees", employees);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("employee", employee);
			request.setAttribute("error", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
		
	}

}
