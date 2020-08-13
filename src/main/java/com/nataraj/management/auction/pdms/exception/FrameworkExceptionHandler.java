package com.nataraj.management.auction.pdms.exception;



import com.nataraj.management.auction.pdms.annotations.ResponseHttpStatus;
import com.nataraj.management.auction.pdms.utils.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class FrameworkExceptionHandler {

    private final LoggingService logger;

    @Autowired
    public FrameworkExceptionHandler(LoggingService logger){
        this.logger = logger;
    }

    @ExceptionHandler(BaseFrameworkException.class)
    public ResponseEntity<FrameworkErrorResponse> handleException(BaseFrameworkException ex){
        FrameworkErrorResponse errorResponse = buildErrorResponse(ex);
        ResponseHttpStatus status = ex.getClass().getAnnotation(ResponseHttpStatus.class);
        HttpStatus statusCode = HttpStatus.resolve(status.value());
        return new ResponseEntity<FrameworkErrorResponse>(errorResponse,statusCode);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FrameworkErrorResponse> handleException(Exception ex){
        ServiceUnavailableException suvException = new ServiceUnavailableException(
                ExceptionCode.UNKNOWN_EXCEPTION.code,
                ExceptionCode.UNKNOWN_EXCEPTION.message);
        FrameworkErrorResponse errorResponse = buildErrorResponse(suvException);
        ResponseHttpStatus status = ex.getClass().getAnnotation(ResponseHttpStatus.class);
        HttpStatus statusCode = HttpStatus.resolve(status.value());
        return new ResponseEntity<FrameworkErrorResponse>(errorResponse,statusCode);
    }

    private FrameworkErrorResponse buildErrorResponse(BaseFrameworkException ex){
        FrameworkErrorResponse error = new FrameworkErrorResponse();
        error.setCode(ex.getErrorCode());
        error.setMessage(ex.getErrorMessage());
        error.setTimestamp(LocalDateTime.now());
        error.setRootCause(ex.getCause().getMessage());
        return error;
    }

    @ResponseHttpStatus(503)
    private class ServiceUnavailableException extends BaseFrameworkException{

        public ServiceUnavailableException(int code, String message) {
            super(code, message);
        }

        public ServiceUnavailableException(String message, Throwable th) {
            super(message, th);
        }
    }
}
