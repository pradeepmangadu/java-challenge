package jp.co.axa.apidemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Custom Exception Handler Class is used to handle the raise Exception when
 * invalid data is passed in PUT Mapping
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeDataException extends RuntimeException {

	public InvalidEmployeeDataException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
