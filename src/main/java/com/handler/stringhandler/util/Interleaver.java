package com.handler.stringhandler.util;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Interleaver {
    public String interleave(Map map) {
        String numbers = (String) map.get("number");
        String alphabets = (String) map.get("alphabet");

        StringBuffer sb = new StringBuffer();
        if (numbers.length() > alphabets.length()) {
            for (int i = 0, len = numbers.length(); i < len; i++) {
                if (i < alphabets.length()) {
                    sb.append(alphabets.substring(i, i + 1));
                    sb.append(numbers.substring(i, i + 1));
                } else {
                    sb.append(numbers.substring(i));
                    break;
                }
            }
        } else {
            for (int i = 0, len = alphabets.length(); i < len; i++) {
                if (i < numbers.length()) {
                    sb.append(alphabets.substring(i, i + 1));
                    sb.append(numbers.substring(i, i + 1));
                } else {
                    sb.append(alphabets.substring(i));
                    break;
                }
            }
        }

        return sb.toString();
    }
}
