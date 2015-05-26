package com.webapplication.servlet.exceptions;

/**
 * Created by Þëÿ on 05.05.2015.
 */
public class InvalidDataException extends CommonException {
    private static final long serialVersionUID = 2025717014644106349L;

    public InvalidDataException(String message) {
        super(message);
    }

    public InvalidDataException(Throwable cause) {
        super(cause);
    }

    public InvalidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
