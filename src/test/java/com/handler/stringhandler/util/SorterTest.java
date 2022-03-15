package com.handler.stringhandler.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    private final Sorter sorter = new Sorter();

    @DisplayName("영어를 정렬할 때 AaBb 순으로 오름차순 정렬한다")
    @Test
    void englishSortTest() {
        final String result = sorter.sortAlphabet("JSjksdDIOAAAjkaaasdFbbbjksdlfjewio");

        assertThat(result).isEqualTo("AAAaaabbbDdddeFfIiJjjjjkkklOoSsssw");
    }

    @DisplayName("숫자를 정렬할 때 0~9 순으로 오름차순 정렬한다")
    @Test
    void numberSortTest() {
        final String result = sorter.sortNumber("7824906217835906890681");

        assertThat(result).isEqualTo("0001122345666778888999");
    }
}