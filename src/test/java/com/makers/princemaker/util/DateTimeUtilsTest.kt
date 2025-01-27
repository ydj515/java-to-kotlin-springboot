package com.makers.princemaker.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class DateTimeUtilsTest {
    @Test
    fun localDateTimeStringTest() {
        val result = getLocalDateTimeString(
            LocalDateTime.of(2023, 12, 21, 10, 10)
        )

        Assertions.assertEquals("2023-12-21 탄생", result)
    }
}