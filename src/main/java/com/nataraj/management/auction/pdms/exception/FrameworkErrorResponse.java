package com.nataraj.management.auction.pdms.exception;

import com.nataraj.lib.exception.aem.ex.BaseFrameworkException;

import java.time.LocalDateTime;

public class FrameworkErrorResponse {
    private int code;
    private String message;
    private LocalDateTime timestamp;
    private String rootCause;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
