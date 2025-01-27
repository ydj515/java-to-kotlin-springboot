package com.makers.princemaker.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusCode {
    HEALTHY("건강한"),
    WOUNDED("부상당한");

    private final String description;
}
