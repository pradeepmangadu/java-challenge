package jp.co.axa.apidemo.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * This Class is used to frame the exception message of
 * EmployeeNotFoundException.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
public class EmployeeNotFoundExceptionResponse {

	@Getter
	@Setter
	String EmployeeNotFound;

	public EmployeeNotFoundExceptionResponse(String employeeNotFound) {
		EmployeeNotFound = employeeNotFound;
	}

}
