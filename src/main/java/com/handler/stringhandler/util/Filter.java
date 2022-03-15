package com.handler.stringhandler.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Filter {
    public Map filter(String data) {
        Map<String, String> result = new HashMap<>();
        result.put("number", filter(data, DataType.NUMBER.getRegularExpression()));
        result.put("alphabet", filter(data, DataType.ALPHABET.getRegularExpression()));

        return result;
    }

    private String filter(String data, String regExp) {
        return data.replaceAll(regExp, "");
    }
}
