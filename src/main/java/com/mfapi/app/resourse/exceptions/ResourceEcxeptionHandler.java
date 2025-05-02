package com.mfapi.app.resourse.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

import com.mfapi.app.servises.exception.ObjectNotFoundException;

@RestControllerAdvice
public class ResourceEcxeptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception,
			HttpServletRequest httpRequest) {
		StandardError standardError = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				exception.getMessage(), httpRequest.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
	}
}
