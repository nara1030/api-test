package com.handler.stringhandler.web;

import com.handler.stringhandler.request.ParseRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String parseDataByPostMethod(@RequestBody final ParseRequest parseRequest) {
        System.out.println(parseRequest.toString());

        return null;
    }
}
