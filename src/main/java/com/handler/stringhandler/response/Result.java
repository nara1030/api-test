package com.handler.stringhandler.response;

public class Result {
    private String share;
    private String remain;

    public Result(String share, String remain) {
        this.share = share;
        this.remain = remain;
    }

    public String getShare() {
        return share;
    }

    public String getRemain() {
        return remain;
    }
}
