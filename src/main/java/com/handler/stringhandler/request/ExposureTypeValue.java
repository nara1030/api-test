package com.handler.stringhandler.request;

import com.handler.stringhandler.exception.InputDataException;
import com.handler.stringhandler.response.ErrorCode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public enum ExposureTypeValue implements ExposureType {
    ALL_TEXT("A") {
        public String parseUrlData(String url) {
            return getDocument(url).html();
        }
    },
    WITHOUT_TAG("B") {
        public String parseUrlData(String url) {
            return getDocument(url).text();
        }
    };

    public String getType() {
        return type;
    }

    // 왜 private은 안되지?
    Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new InputDataException(ErrorCode.NOT_FOUND_URL, url);
        }

        return document;
    }

    private ExposureTypeValue(String type) {
        this.type = type;
    }

    private String type;
}
