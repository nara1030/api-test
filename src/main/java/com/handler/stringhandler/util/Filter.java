package com.handler.stringhandler.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Filter {
    public Map filter(String data) {
        Map<String, String> result = new HashMap<>();
        result.put("number", filter(data, DataType.NUMBER.regularExpression));
        result.put("alphabet", filter(data, DataType.ALPHABET.regularExpression));

        return result;
    }

    private String filter(String data, String regExp) {
        return data.replaceAll(regExp, "");
    }

    enum DataType {
        NUMBER("N", "[^0-9]"),
        ALPHABET("A", "[^a-zA-Z]");

        private DataType(String dataType, String regularExpression) {
            this.dataType = dataType;
            this.regularExpression = regularExpression;
        }

        private String dataType;
        private String regularExpression;
    }
}
