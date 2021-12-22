package com.greenqbit.dao;
import java.util.List;

import com.greenqbit.model.Employee;


public interface EmployeeDao {
	void saveEmployee(Employee stud) throws Exception;
	
	Employee getEmployee(long id) throws Exception;

	List<Employee> getAllEmployees() throws Exception;
	
	void updateEmployee(Employee stud) throws Exception;

	void delete(Long id) throws Exception;

}
