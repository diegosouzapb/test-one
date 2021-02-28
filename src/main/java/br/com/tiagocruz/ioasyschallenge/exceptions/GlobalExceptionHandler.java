package br.com.tiagocruz.ioasyschallenge.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.google.common.base.Joiner;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected Issue processExceptions(final Exception ex, final WebRequest request) {

		return new Issue(IssueEnum.UNEXPECTED_ERROR, Collections.singletonList(ex.getLocalizedMessage()));
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED, value = HttpStatus.METHOD_NOT_ALLOWED)
	protected Issue processHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException ex,
			final WebRequest request) {

		return new Issue(IssueEnum.METHOD_NOT_ALLOWED, ex.getMethod(),
				Joiner.on(", ").join(Objects.requireNonNull(ex.getSupportedHttpMethods())));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected Issue handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final WebRequest request) {

		final List<String> errors = new ArrayList<>();
		for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}

		return new Issue(IssueEnum.BAD_REQUEST, errors);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	protected Issue hadleHttpMessageNotReadableException(final HttpMessageNotReadableException ex, final WebRequest request) {

		return new Issue(IssueEnum.JSON_DESERIALIZE_ERROR);
	}

	//Todo: Business Exceptions.
}
