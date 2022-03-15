package com.handler.stringhandler.request;

public class ParseRequest {
    private String url;
    private String exposureType;
    private Integer share;

    public ParseRequest(String url, String exposureType, Integer share) {
        this.url = url;
        this.exposureType = exposureType;
        this.share = share;
    }

    // 값 제대로 들어왔는지 확인 용도
    @Override
    public String toString() {
        return "ParseRequest{" +
                "url='" + url + '\'' +
                ", exposureType='" + exposureType + '\'' +
                ", share=" + share +
                '}';
    }
}
