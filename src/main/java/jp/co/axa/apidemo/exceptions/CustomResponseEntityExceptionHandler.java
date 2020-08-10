package jp.co.axa.apidemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Custom Exception Handler Class is used to handle the exceptions that are
 * happening in REST Controller
 *
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectNotFoundException(EmployeeNotFoundException ex,
			WebRequest request) {
		EmployeeNotFoundExceptionResponse exceptionResponse = new EmployeeNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleUserNameAlreadyExistsException(InvalidEmployeeDataException ex,
			WebRequest request) {
		InvalidEmployeeDataExceptionResponse exceptionResponse = new InvalidEmployeeDataExceptionResponse(
				ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
