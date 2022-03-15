package com.handler.stringhandler.web;

import com.handler.stringhandler.exception.InputDataException;
import com.handler.stringhandler.request.ParseRequest;
import com.handler.stringhandler.response.ErrorCode;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ParseController {
    /**
     * POST REST API
     *
     * @param
     * @return
     * @exception
     */
    @PostMapping("/api")
    public String parseDataByPostMethod(@RequestBody @Valid final ParseRequest parseRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputDataException(ErrorCode.INVALID_INPUT_VALUE, bindingResult);
        }

        System.out.println(parseRequest.getUrlData());

        return null;
    }
}
