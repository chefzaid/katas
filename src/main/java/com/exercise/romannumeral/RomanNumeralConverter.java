package com.exercise.romannumeral;

public class RomanNumeralConverter implements RomanConverter {
    
    @Override
    public int convert(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int total = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = RomanSymbol.valueOf(s.charAt(i)).getValue();
            total += (curr < prev) ? -curr : curr;
            prev = curr;
        }
        return total;
    }
}
