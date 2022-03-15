package com.handler.stringhandler.service;

import com.handler.stringhandler.response.Result;
import org.springframework.stereotype.Service;

@Service
public class ParseService {
    public Result parse(final String data, final Integer unit) {
        int len = data.length();
        if (unit >= len) {
            return new Result(data, "");
        }

        String share = data.substring(0, len - (len % unit));
        String remain = data.substring(len - (len % unit), len);

        return new Result(share, remain);
    }
}
