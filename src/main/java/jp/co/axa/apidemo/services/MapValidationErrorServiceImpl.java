package jp.co.axa.apidemo.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * This Class implements the methods from MapValidationErrorService interface
 * which is used by the controller for producing validation errors.
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
@Service
public class MapValidationErrorServiceImpl implements MapValidationErrorService {

	public ResponseEntity<?> MapValidationService(BindingResult result) {
		// Check for errors in binding result
		if (result.hasErrors()) {
			Map<String, String> errorMap = new HashMap<>();
			for (FieldError error : result.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}

			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
		}
		return null;

	}
}
