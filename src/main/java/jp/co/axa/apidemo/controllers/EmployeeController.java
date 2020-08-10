package jp.co.axa.apidemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import jp.co.axa.apidemo.services.MapValidationErrorService;

/**
 * This Rest Controller class is used to handle the mapping the URL with
 * corresponding methods that needs to be called when user post a request.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private MapValidationErrorService mapValidationErrorService;

	/**
	 * This method is used to retrieving all the Employees from the Database.
	 * 
	 * @param null
	 * @return Response Entity.
	 */
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		// Get all the employees data from service
		List<Employee> employees = employeeService.retrieveEmployees();
		return employees;
	}

	/**
	 * This method is used to retrieving the Employee of the given Employee ID from
	 * the Database.
	 * 
	 * @param employeeId Long.
	 * @return Response Entity.
	 */
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<?> getEmployee(@PathVariable Long employeeId) {
		// Get the employee object from service
		Employee employee = employeeService.getEmployee(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	/**
	 * This method is used to crate a new Employees and store it in Database.
	 * 
	 * @param Employee      Object.
	 * @param BindingResult result of the validation.
	 * @return Response Entity.
	 */
	@PostMapping("/employees")
	public ResponseEntity<?> saveEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
		// check for validation errors
		ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
		if (errorMap != null)
			return errorMap;
		// call save service method
		employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	/**
	 * This method is used to delete the Employee of the given Employee ID from the
	 * Database.
	 * 
	 * @param employeeId Long.
	 * @return Response Entity.
	 */
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
		// call delete service
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee with ID '" + employeeId + "' is deleted", HttpStatus.OK);

	}

	/**
	 * This method is used to update the details of Employee for the given Employee
	 * ID from the Database.
	 * 
	 * @param Employee   Object.
	 * @param employeeId Long.
	 * @return Response Entity.
	 */
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
		// send the data to update service
		Employee updatedEmployee = employeeService.updateEmployee(employeeId, employee);
		return new ResponseEntity<Employee>(updatedEmployee, HttpStatus.OK);
	}

}
