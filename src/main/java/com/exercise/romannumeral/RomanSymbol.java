package com.exercise.romannumeral;

public enum RomanSymbol {
    I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

    private final int value;

    RomanSymbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RomanSymbol valueOf(char c) {
        return RomanSymbol.valueOf(String.valueOf(c));
    }
}
