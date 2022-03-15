package com.handler.stringhandler.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    @DisplayName("String을 입력받을 때 숫자 이외의 값이 포함된 경우 지운다")
    @Test
    void filterNumber() {
        final Filter filter = new Filter();
        final String number = (String) filter.filter("e4C3!d@BA#1a$Df%2c^EA[b0]bF").get("number");

        assertThat(number).isEqualTo("43120");
    }

    @DisplayName("String을 입력받을 때 영어 이외의 값이 포함된 경우 지운다")
    @Test
    void filterEnglish() {
        final Filter filter = new Filter();
        final String alphabet = (String) filter.filter("e4C3!d@BA#1a$Df%2c^EA[b0]bF").get("alphabet");

        assertThat(alphabet).isEqualTo("eCdBAaDfcEAbbF");
    }
}