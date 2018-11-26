package com.kodilla.stream.array;

import java.util.stream.IntStream;

public class ArrayOperations {
    public static double getAverage(int[] numbers) {
        double getAverage = IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .peek(n -> System.out.println(n))
                .average().orElse(0);
        return getAverage;

    }
}
