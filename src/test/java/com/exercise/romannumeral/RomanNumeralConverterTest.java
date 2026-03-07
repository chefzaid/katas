package com.exercise.romannumeral;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralConverterTest {

    private final RomanConverter converter = new RomanNumeralConverter();

    @Test
    public void testStandardCases() {
        assertEquals(1, converter.convert("I"));
        assertEquals(3, converter.convert("III"));
        assertEquals(4, converter.convert("IV"));
        assertEquals(9, converter.convert("IX"));
        assertEquals(58, converter.convert("LVIII"));
        assertEquals(1994, converter.convert("MCMXCIV"));
    }

    @Test
    public void testEmptyAndNull() {
        assertEquals(0, converter.convert(""));
        assertEquals(0, converter.convert(null));
    }

    @Test
    public void testInvalidCharacter() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert("A"));
    }
}
