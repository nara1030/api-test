package com.handler.stringhandler.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Arranger {
    private final Filter filter;
    private final Sorter sorter;

    public Arranger(Filter filter, Sorter sorter) {
        this.filter = filter;
        this.sorter = sorter;
    }

    public Map rearrange(final String data) {
        return sorter.sort(filter.filter(data));
    }
}

enum DataType {
    NUMBER("N", "[^0-9]"),
    ALPHABET("A", "[^a-zA-Z]");

    private DataType(String dataType, String regularExpression) {
        this.dataType = dataType;
        this.regularExpression = regularExpression;
    }

    public String getRegularExpression() {
        return regularExpression;
    }

    private String dataType;
    private String regularExpression;
}