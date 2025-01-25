package com.contrifun;

import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumberFinder {
    
    public List<Integer> findPrimesInRange(int start, int end) {
        if (start < 1 || end < start || end > 10) {
            throw new IllegalArgumentException("Range must be between 1 and 10, and start must be less than or equal to end");
        }
        
        return IntStream.rangeClosed(start, end)
                .filter(this::isPrime)
                .boxed()
                .toList();
    }
    
    public List<Integer> findAllPrimes() {
        return findPrimesInRange(1, 10);
    }
    
    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}