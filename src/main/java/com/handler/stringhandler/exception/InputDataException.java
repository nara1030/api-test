package com.handler.stringhandler.exception;

import com.handler.stringhandler.response.ErrorCode;
import org.springframework.validation.BindingResult;

public class InputDataException extends RuntimeException {
    private ErrorCode errorCode;

    // Field별 에러를 던져주기 위해 하단 추가되었으나 고민 필요
    private BindingResult bindingResult;
    private String url;

    public InputDataException(ErrorCode errorCode, BindingResult bindingResult) {
        this.errorCode = errorCode;
        this.bindingResult = bindingResult;
        this.url = null;
    }

    // HttpStatus = 404
    public InputDataException(ErrorCode errorCode, String url) {
        this.errorCode = errorCode;
        this.url = url;
        this.bindingResult = null;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public String getUrl() {
        return url;
    }
}
