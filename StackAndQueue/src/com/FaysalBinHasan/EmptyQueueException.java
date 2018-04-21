package com.FaysalBinHasan;


public class EmptyQueueException extends RuntimeException {
    /**
     * Creates a new EmptyQueueException.
     */
    public EmptyQueueException() {
        super();
    }

    /**
     * Creates a new EmptyQueueException with specified message.
     * 
     * @param message the exception message.
     */
    public EmptyQueueException(String message) {
        super(message);
    }

    private final static long serialVersionUID = 2010L;
}
