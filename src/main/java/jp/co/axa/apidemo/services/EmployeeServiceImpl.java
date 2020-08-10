package jp.co.axa.apidemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exceptions.EmployeeNotFoundException;
import jp.co.axa.apidemo.exceptions.InvalidEmployeeDataException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;

/**
 * This Class implements the methods from EmployeeService interface which is
 * used by the controller
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * This method is used to retrieving all the Employees from the Database.
	 * 
	 * @param null
	 * @return List(Employees)
	 */
	public List<Employee> retrieveEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	/**
	 * This method is used to retrieving the Employee of the given Employee ID from
	 * the Database.
	 * 
	 * @param employeeId Long.
	 * @return Employee Object
	 */
	public Employee getEmployee(Long employeeId) {
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (!employee.isPresent()) {
			throw new EmployeeNotFoundException("Employee ID '" + employeeId + "' does not exist");
		}
		return employee.get();
	}

	/**
	 * This method is used to crate a new Employees and store it in Database.
	 * 
	 * @param Employee      Object.
	 * @param BindingResult result of the validation.
	 * @return Employee Object
	 */
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/**
	 * This method is used to delete the Employee of the given Employee ID from the
	 * Database.
	 * 
	 * @param employeeId Long.
	 * @return null
	 */
	public void deleteEmployee(Long employeeId) {
		employeeRepository.delete(getEmployee(employeeId));
	}

	/**
	 * This method is used to update the details of Employee for the given Employee
	 * ID from the Database.
	 * 
	 * @param Employee   Object.
	 * @param employeeId Long.
	 * @return Employee Object.
	 */
	public Employee updateEmployee(Long employeeId, Employee employee) {
		Employee existingEmployee = getEmployee(employeeId);
		// Check for Employee Name for Null Values
		if (employee.getName().isEmpty()) {
			throw new InvalidEmployeeDataException("Employee Name cannot be Empty");
		}
		// Check for Employee Salary for negative numbers
		if (employee.getSalary() <= 0) {
			throw new EmployeeNotFoundException("Employee Salary Should be greater than 0");
		}
		// Check for Employee Salary for Null Values
		if (employee.getSalary() == null) {
			throw new InvalidEmployeeDataException("Employee Salary cannot be Empty");
		}
		// Check for Employee Department for Null Values
		if (employee.getDepartment().isEmpty()) {
			throw new InvalidEmployeeDataException("Employee Department cannot be Empty");
		}
		if (existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setSalary(employee.getSalary());
			existingEmployee.setDepartment(employee.getDepartment());
			employeeRepository.save(existingEmployee);
		}
		return existingEmployee;
	}

}