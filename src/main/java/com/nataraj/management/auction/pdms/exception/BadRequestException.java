package com.nataraj.management.auction.pdms.exception;

import com.nataraj.management.auction.pdms.annotations.ResponseHttpStatus;

@ResponseHttpStatus(400)
public class BadRequestException extends BaseFrameworkException {


    public BadRequestException(int code, String message) {
        super(code, message);
    }

    public BadRequestException(String message) {
        this(ExceptionCode.BAD_REQUEST_EXCEPTION.code, message);
    }

    public BadRequestException(String message, Throwable th) {
        super(message, th);
    }
}
