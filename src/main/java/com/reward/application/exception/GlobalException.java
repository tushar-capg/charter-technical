package com.reward.application.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.reward.application.exception.model.ErrorModel;

import jakarta.validation.ValidationException;
/**
 * Represents an global exception handler.
 * Used to handle exception occurs in any of the controller.
 */
@RestControllerAdvice
public class GlobalException {
	/**
     * Handles ValidationException when an invalid input is provided.
     * @param ex The caught ValidationException.
     * @return A structured error response with message and HTTP 400 status.
     */
	@ExceptionHandler(ValidationException.class)
	public ErrorModel validationException(ValidationException e) {
		return new ErrorModel(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
	/**
     * Handles MethodArgumentNotValidException when an invalid input is provided.
     * @param ex The caught MethodArgumentNotValidException.
     * @return A structured error response with message and HTTP 400 status.
     */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorModel validationException(MethodArgumentNotValidException e) {
		return new ErrorModel(HttpStatus.BAD_REQUEST.toString(), e.getBindingResult().getFieldError().getDefaultMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
	/**
     * Handles IllegalArgumentException when an invalid input is provided.
     * @param ex The caught IllegalArgumentException.
     * @return A structured error response with message and HTTP 404 status.
     */
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorModel validationException(IllegalArgumentException e) {
		return new ErrorModel(HttpStatus.NOT_FOUND.toString(), e.getLocalizedMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
	/**
     * Handles Exception when an unexpected exception occurs.
     * @param ex The caught Exception.
     * @return A structured error response with message and HTTP 500 status.
     */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorModel validationException(Exception e) {
		return new ErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.getMessage(), LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}
