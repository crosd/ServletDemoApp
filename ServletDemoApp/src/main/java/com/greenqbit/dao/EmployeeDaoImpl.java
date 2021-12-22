package com.greenqbit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.greenqbit.db.DBConnection;
import com.greenqbit.model.Employee;

public class EmployeeDaoImpl extends DBConnection implements EmployeeDao{

	@Override
	public void saveEmployee(Employee employee) throws Exception {
		Connection conn = getDBConnection();

		String sql = "INSERT INTO `employee` (`name`, `position`, `company`, `department`) VALUES (?, ?, ?, ?)";

		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, employee.getName());
		stat.setString(2, employee.getPosition());
		stat.setString(3, employee.getCompany());
		stat.setString(4, employee.getDepartment());
	

		stat.executeUpdate(); // execute query

		conn.close();

	}
	
	

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> employeeList = new ArrayList<Employee>();

		Connection conn = getDBConnection();
		Statement stat = conn.createStatement();

		ResultSet rs = stat.executeQuery("SELECT * FROM employee");
		while (rs.next()) {
			// `name`, `roll_no`, `phone_no`, `gender`, `email`, `address`,
			// `college_name`

			Employee employee = new Employee();
			employee.setId(rs.getLong("id"));
			employee.setName(rs.getString("name"));
			employee.setPosition(rs.getString("position"));
			employee.setCompany(rs.getString("company"));
			employee.setDepartment(rs.getString("department"));
			

			employeeList.add(employee);
		}

		conn.close();
		return employeeList;
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		Connection conn = getDBConnection();

		String sql = "UPDATE `employee` SET `name` = ? , `position` = ? , `company` = ? , `department` = ?  WHERE `id` = ?";

		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, employee.getName());
		stat.setString(2, employee.getPosition());
		stat.setString(3, employee.getCompany());
		stat.setString(4, employee.getDepartment());
		stat.setLong(5, employee.getId());
		

		stat.executeUpdate(); // execute query

		conn.close();
	}

	@Override
	public void delete(Long id) throws Exception {
		Connection conn = getDBConnection();
		Statement stat = conn.createStatement();
		stat.executeUpdate("DELETE FROM employee where id = " + id);
		conn.close();
	}



	@Override
	public Employee getEmployee(long id) throws Exception {
		Employee employee = new Employee();
        String sql = "SELECT * FROM employee WHERE id = ?";
         
        Connection conn = getDBConnection();
         
        PreparedStatement stat = conn.prepareStatement(sql);
        stat.setLong(1, id);
         
        ResultSet resultSet = stat.executeQuery();
         
        if (resultSet.next()) {
        	employee.setId(resultSet.getLong("id"));
        	employee.setName(resultSet.getString("name"));
        	employee.setPosition(resultSet.getString("position"));
        	employee.setCompany(resultSet.getString("company"));
        	employee.setDepartment(resultSet.getString("department"));
        
        }
         
        resultSet.close();
        stat.close();
        conn.close();
         
        return employee;
	}

}
