package com.handler.stringhandler.exception;

import com.handler.stringhandler.response.ErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {InputDataException.class})
    protected ResponseEntity<ErrorResult> handleInputDataException(final InputDataException e) {
        ErrorResult errorResult = null;
        if (404 == e.getErrorCode().getHttpStatus()) { // 이렇게 하면 에러 추가시마다 분기 처리해야 하는데...
            errorResult = ErrorResult.of(e.getErrorCode(), ErrorResult.FieldError.of("url", e.getUrl(), e.getErrorCode().getMessage()));
        } else {
            errorResult = ErrorResult.of(e.getErrorCode(), e.getBindingResult());
        }

        return new ResponseEntity<>(errorResult, HttpStatus.BAD_REQUEST);
    }
}
