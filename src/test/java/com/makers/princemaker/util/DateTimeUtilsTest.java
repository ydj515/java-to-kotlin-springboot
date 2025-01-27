package com.makers.princemaker.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.makers.princemaker.util.DateTimeUtilsKt.getLocalDateTimeString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeUtilsTest {
    @Test
    void getLocalDateTimeStringTest() {
        String result = getLocalDateTimeString(
                LocalDateTime.of(2023, 12, 21, 10, 10)
        );

        assertEquals("2023-12-21 탄생", result);
    }
}