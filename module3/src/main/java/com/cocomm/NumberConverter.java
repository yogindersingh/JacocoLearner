package com.cocomm;

public class NumberConverter {
    
    public String convert(int number) {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Number must be between 1 and 10");
        }
        
        return switch (number) {
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }
}