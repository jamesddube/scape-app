package com.jamesdube.scape.utils.enums;

public enum SubjectLevel {

    ADVANCED("ADVANCED"),ORDINARY("ORDINARY");

    private String value;

    SubjectLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
