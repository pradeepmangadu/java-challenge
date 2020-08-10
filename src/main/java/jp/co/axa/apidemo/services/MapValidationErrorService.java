package jp.co.axa.apidemo.services;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

/**
 * This interface is used to generate a valid error response for bean validation
 * errors
 * 
 * @author Pradeep
 * @version 1.0
 * @since 2020-08-10
 */
public interface MapValidationErrorService {

	public ResponseEntity<?> MapValidationService(BindingResult result);
}
