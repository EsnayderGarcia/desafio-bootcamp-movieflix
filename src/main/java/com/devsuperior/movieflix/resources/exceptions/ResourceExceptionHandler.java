package com.devsuperior.movieflix.resources.exceptions;


import com.devsuperior.movieflix.services.exceptions.DataBaseException;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, 
			HttpServletRequest req){
			
		StandardError error = new StandardError();
		
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError(ex.getMessage());
		error.setPath(req.getRequestURI());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataIntegretyViolation(DataBaseException ex,
			HttpServletRequest req) {
		
		StandardError error = new StandardError();
		
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setError(ex.getMessage());
		error.setPath(req.getRequestURI());
		
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> notValidArgument(MethodArgumentNotValidException ex,
			HttpServletRequest req) {
		ValidationError error = new ValidationError();
		
		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setError("Um ou mais campos estão inválidos");
		error.setPath(req.getRequestURI());
		
		ex.getBindingResult()
			.getFieldErrors()
			.forEach(f -> error.addError(new FieldMessage(f.getField(), f.getDefaultMessage())));
		
		return ResponseEntity.unprocessableEntity().body(error);
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<OauthCustomError> forbbidenException(ForbiddenException ex, HttpServletRequest req) {
		OauthCustomError error = new OauthCustomError("Forbidden", ex.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<OauthCustomError> UnauthorizedException(UnauthorizedException ex, HttpServletRequest req) {
		OauthCustomError error = new OauthCustomError("Unauthorized", ex.getMessage());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
	}
}






