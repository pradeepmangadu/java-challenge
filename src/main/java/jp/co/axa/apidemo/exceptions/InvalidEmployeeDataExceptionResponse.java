package jp.co.axa.apidemo.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * This Class is used to frame the exception message of
 * InvalidEmployeeDataException.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
public class InvalidEmployeeDataExceptionResponse {

	@Getter
	@Setter
	private String employeeData;

	public InvalidEmployeeDataExceptionResponse(String employeeData) {
		this.employeeData = employeeData;
	}

}
