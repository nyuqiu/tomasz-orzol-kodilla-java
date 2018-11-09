package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> argument = new ArrayList<>();
        //When
        ArrayList<Integer> empty = oddNumbersExterminator.exterminate(argument);
        System.out.println("Testing: "+empty);
        //Then
        Assert.assertEquals(argument, empty);
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
            //Given
            OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
            ArrayList<Integer> argument = new ArrayList<>();
            Random random = new Random();
            for(int i=0; i<random.nextInt(50);i++){
                argument.add(random.nextInt(50));
            }
            //When
            ArrayList<Integer> ready = oddNumbersExterminator.exterminate(argument);
            ArrayList<Integer> evenNumbers = new ArrayList<>();
            for(int i=0; i<argument.size();i++){
                int testNumber = argument.get(i);
                if(testNumber%2==0){
                    evenNumbers.add(testNumber);
                }
            }
            System.out.println("Testing: "+argument);
            //Then
            Assert.assertEquals(ready, evenNumbers);
    }

}
