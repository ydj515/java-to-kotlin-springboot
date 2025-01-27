package com.makers.princemaker.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun getLocalDateTimeString(localDateTime: LocalDateTime): String {
    return localDateTime.format(
        DateTimeFormatter
            .ofPattern("yyyy-MM-dd 탄생")
    )
}
