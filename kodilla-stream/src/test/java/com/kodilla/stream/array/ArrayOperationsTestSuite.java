package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        // Given
        int[] numbers = {1,2,3,4,5,6,7,8,9};

        //When
        double result = ArrayOperations.getAverage(numbers);

        //Then//
        Assert.assertEquals( 5.0, result,0);
    }
}
