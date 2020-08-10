package jp.co.axa.apidemo.services;

import java.util.List;

import jp.co.axa.apidemo.entities.Employee;

/**
 * The Service is used to support the controller class in retrieving the data
 * with DB and also holds the business logic.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
public interface EmployeeService {

	public List<Employee> retrieveEmployees();

	public Employee getEmployee(Long employeeId);

	public Employee saveEmployee(Employee employee);

	public void deleteEmployee(Long employeeId);

	public Employee updateEmployee(Long employeeId, Employee employee);
}