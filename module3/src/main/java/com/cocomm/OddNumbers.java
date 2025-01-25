package com.cocomm;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {

    /**
     * Returns all odd numbers between the given range [start, end].
     *
     * @param start the starting number of the range (inclusive)
     * @param end   the ending number of the range (inclusive)
     * @return a list of odd numbers within the range
     */
    public static List<Integer> getOddNumbersInRange(int start, int end) {
        List<Integer> oddNumbers = new ArrayList<>();
        if (start < 1 || end > 20 || start > end) {
            throw new IllegalArgumentException("Range must be within 1 to 20, and start must not be greater than end.");
        }

        for (int i = start; i <= end; i++) {
            if (i % 2 != 0) {
                oddNumbers.add(i);
            }
        }
        return oddNumbers;
    }
}