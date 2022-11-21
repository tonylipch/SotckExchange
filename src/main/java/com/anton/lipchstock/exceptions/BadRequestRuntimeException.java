package com.anton.lipchstock.exceptions;

public class BadRequestRuntimeException extends Throwable {
    public BadRequestRuntimeException(String format, String ... args) {
        super(String.format(format, args));
    }

}
