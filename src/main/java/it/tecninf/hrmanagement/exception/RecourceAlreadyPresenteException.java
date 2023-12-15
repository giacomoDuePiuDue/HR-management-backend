package it.tecninf.hrmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class RecourceAlreadyPresenteException extends RuntimeException{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	 private String fieldName;
	    

	    public RecourceAlreadyPresenteException(String resourceName, String fieldName) {
	        super(String.format("already present  : ", resourceName, fieldName)); // Post not found with id : 1
	        this.resourceName = resourceName;
	        this.fieldName = fieldName;
	        
	    }

	    public String getResourceName() {
	        return resourceName;
	    }

	    public String getFieldName() {
	        return fieldName;
	    }

	   
}