package com.nataraj.management.auction.pdms.exception;


import com.nataraj.management.auction.pdms.annotations.ResponseHttpStatus;

@ResponseHttpStatus(404)
public class DataNotFoundException extends BaseFrameworkException {


    public DataNotFoundException(int code, String message) {
        super(code, message);
    }

    public DataNotFoundException(String message) {
        this(ExceptionCode.NOT_FOUND_EXCEPTION.code, message);
    }

    public DataNotFoundException(String message, Throwable th) {
        super(message, th);
    }
}
