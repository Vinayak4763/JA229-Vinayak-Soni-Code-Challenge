package com.hexaware.cricketsystem.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlayerNotFoundException(String message) {
        super(message);
    }
}
