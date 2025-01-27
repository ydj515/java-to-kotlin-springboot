package com.makers.princemaker.util

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions
import java.time.LocalDateTime

class DateTimeUtilsTest : StringSpec({
    "탄생일 출력 검증" {
        val result = getLocalDateTimeString(
            LocalDateTime.of(2023, 12, 21, 10, 10)
        )

        result shouldBe "2023-12-21 탄생"
    }
})