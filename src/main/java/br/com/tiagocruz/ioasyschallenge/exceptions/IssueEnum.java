package br.com.tiagocruz.ioasyschallenge.exceptions;

import java.util.IllegalFormatException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum IssueEnum {
	UNEXPECTED_ERROR(6, "Unexpected error. Please contact system administrator."),
	METHOD_NOT_ALLOWED(7, "%s method is not supported for this request. Supported methods are [%s]"),
	BAD_REQUEST(8, "Malformed Request"),
	JSON_DESERIALIZE_ERROR(9, "Can not deserialize JSON."),
	CONFLICT(10, "This information already exists.");

	// not static because ENUMS are initialized before static fields by JVM
	private final Logger logger = LogManager.getLogger(IssueEnum.class);
	private final int code;
	private final String message;

	IssueEnum(final int code, final String message) {

		this.code = code;
		this.message = message;
	}

	public int getCode() {

		return code;
	}

	public String getFormattedMessage(final Object... args) {

		if (message == null) {
			return "";
		}

		try {
			return String.format(message, args);
		} catch (final IllegalFormatException e) {
			logger.warn(e.getMessage(), e);
			return message.replace("%s", "");
		}
	}
}
