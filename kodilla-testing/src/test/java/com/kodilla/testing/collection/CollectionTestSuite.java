package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        System.out.println("Testing "+empty);
        //Then
        for(int i=0; i<empty.size(); i++){
            Assert.assertEquals(empty.get(i), argument.get(i));
        }
    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
            //Given
            OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
            ArrayList<Integer> argument = new ArrayList<>();
            argument.add(1);
            argument.add(2);
            argument.add(3);
            argument.add(4);
            argument.add(5);
            argument.add(6);
            //When
            ArrayList<Integer> ready = oddNumbersExterminator.exterminate(argument);
            ArrayList<Integer> evenNumbers = new ArrayList<>();
            for(int i=0; i<argument.size();i++){
                int testNumber = argument.get(i);
                if(testNumber%2==0){
                    evenNumbers.add(testNumber);
                }
            }
            System.out.println("Testing "+argument);
            //Then
            for(int i=0; i<ready.size(); i++){
                Assert.assertEquals(ready.get(i), evenNumbers.get(i));
            }
        }
}
