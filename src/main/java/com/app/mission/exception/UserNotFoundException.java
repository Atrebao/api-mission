package com.app.mission.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
    
    public UserNotFoundException(String message, Long id) {
    	super(message+ " "+id);
    }
}
