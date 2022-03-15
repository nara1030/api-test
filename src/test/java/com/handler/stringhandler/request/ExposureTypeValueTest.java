package com.handler.stringhandler.request;

import com.handler.stringhandler.exception.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExposureTypeValueTest {
    @DisplayName("잘못된 url입력시 InputDataException이 발생한다(A).")
    @Test
    void htmlFailTest() {
        assertThatThrownBy(() -> ExposureTypeValue.ALL_TEXT.parseUrlData("https://www.naver.com/eom"))
                .isInstanceOf(InputDataException.class);
    }

    @DisplayName("url입력시 html을 가져올 수 있다.")
    @ParameterizedTest
    @CsvSource({"https://www.naver.com, <title>NAVER</title>", "https://www.google.com, <title>Google</title>"})
    void htmlSuccessTest(final String url, final String title) {
        final String result = ExposureTypeValue.ALL_TEXT.parseUrlData(url);

        assertThat(result.contains(title)).isTrue();
    }

    @DisplayName("잘못된 url입력시 InputDataException이 발생한다(B).")
    @Test
    void textFailTest() {
        assertThatThrownBy(() -> ExposureTypeValue.ALL_TEXT.parseUrlData("https://www.google.com/eom"))
                .isInstanceOf(InputDataException.class);
    }

    @DisplayName("url입력시 text을 가져올 수 있다.")
    @ParameterizedTest
    @CsvSource({"https://www.naver.com, NAVER", "https://www.google.com, Google"})
    void textSuccessTest(final String url, final String title) {
        final String result = ExposureTypeValue.WITHOUT_TAG.parseUrlData(url);

        assertThat(result.contains(title)).isTrue(); // 이게 유효한가?
    }
}