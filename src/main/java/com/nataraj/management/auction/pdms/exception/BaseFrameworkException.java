package com.nataraj.management.auction.pdms.exception;

abstract public class BaseFrameworkException extends RuntimeException{
    private int errorCode;
    private String errorMessage;


    public BaseFrameworkException(int code, String message){
        this.errorCode = code;
        this.errorMessage = message;
    }

    public BaseFrameworkException(String message, Throwable th){
        super(message,th);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
