package com.handler.stringhandler.util;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Sorter {
    public Map sort(Map map) {
        Map<String, String> result = new HashMap<>();
        String numbers = (String) map.get("number");
        String alphabets = (String) map.get("alphabet");

        result.put("number", sortNumber(numbers));
        result.put("alphabet", sortAlphabet(alphabets));

        return result;
    }

    // 단위 테스트 위해 접근 제한자 private -> default 변경
    String sortNumber(String numberStr) {
        int[] numberArray = new int[numberStr.length()];
        for (int i = 0, len = numberStr.length(); i < len; i++) {
            numberArray[i] = Integer.parseInt(numberStr.substring(i, i + 1));
        }

        Arrays.sort(numberArray);
        return Arrays.stream(numberArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
    }

    // 단위 테스트 위해 접근 제한자 private -> default 변경
    String sortAlphabet(String alphabetStr) {
        String[] alphabetArray = new String[alphabetStr.length()];
        for (int i = 0, len = alphabetStr.length(); i < len; i++) {
            alphabetArray[i] = alphabetStr.substring(i, i + 1);
        }

        Arrays.sort(alphabetArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int res = o1.compareToIgnoreCase(o2);
                return (res == 0) ? o1.compareTo(o2) : res;
            }
        });

        return String.join("", alphabetArray);
    }
}
