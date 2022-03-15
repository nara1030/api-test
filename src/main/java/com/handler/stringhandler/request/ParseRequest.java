package com.handler.stringhandler.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ParseRequest {
    @NotNull(message = "URL은 필수 입력값입니다.")
    private String url;
    @NotNull(message = "노출유형은 필수 입력값입니다.")
    private String exposureType;
    @NotNull(message = "출력묶음 단위는 필수 입력값입니다.")
    @Min(value = 1, message = "출력묶음 단위는 양수여야 합니다.")
    private Integer share;

    public String getUrlData() {
        String data = null;
        for (ExposureTypeValue exposureTypeValue : ExposureTypeValue.values()) {
            if (exposureType.equals(exposureTypeValue.getType())) {
                data = exposureTypeValue.parseUrlData(url);
            }
        }

        return data;
    }

    public ParseRequest(String url, String exposureType, Integer share) {
        this.url = url;
        this.exposureType = exposureType;
        this.share = share;
    }
}
