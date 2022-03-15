package com.handler.stringhandler.web;

import com.handler.stringhandler.exception.InputDataException;
import com.handler.stringhandler.request.ParseRequest;
import com.handler.stringhandler.response.ErrorCode;
import com.handler.stringhandler.response.Result;
import com.handler.stringhandler.service.ParseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class ParseController {
    private final ParseService parseService;

    public ParseController(ParseService parseService) {
        this.parseService = parseService;
    }

    /**
     * POST REST API
     *
     * @param
     * @return
     * @exception
     */
    @PostMapping("/api")
    public ResponseEntity<Result> parseDataByPostMethod(@RequestBody @Valid final ParseRequest parseRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputDataException(ErrorCode.INVALID_INPUT_VALUE, bindingResult);
        }

        final String originalData = parseRequest.getUrlData();
        final Map rearrangedData = parseService.parse(originalData);
        System.out.println(rearrangedData.get("number"));
        System.out.println(rearrangedData.get("alphabet"));

        final Result response = parseService.output(originalData, parseRequest.getShare());

        return ResponseEntity.ok(response);
    }
}
