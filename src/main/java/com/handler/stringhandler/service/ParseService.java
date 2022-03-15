package com.handler.stringhandler.service;

import com.handler.stringhandler.response.Result;
import com.handler.stringhandler.util.Arranger;
import com.handler.stringhandler.util.Interleaver;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ParseService {
    private final Interleaver interleaver;
    private final Arranger arranger;

    public ParseService(Interleaver interleaver, Arranger arranger) {
        this.interleaver = interleaver;
        this.arranger = arranger;
    }

    public String parse(final String data) {
        return interleaver.interleave(arranger.rearrange(data));
    }

    public Result output(final String data, final Integer unit) {
        int len = data.length();
        if (unit >= len) {
            return new Result(data, "");
        }

        String share = data.substring(0, len - (len % unit));
        String remain = data.substring(len - (len % unit), len);

        return new Result(share, remain);
    }
}
