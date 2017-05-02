package main.java;

public class NoEscapeException extends Exception {

	/**
	 * Assigned with default values
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Overloaded constructor
	 * @param message
	 */
	public NoEscapeException(String message) {
		super(message);
	}
}
