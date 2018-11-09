package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    ArrayList<Integer> exterminate(ArrayList<Integer> numbers){
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        for(int i=0; i<numbers.size();i++){
            int testNumber = numbers.get(i);
            if(testNumber%2==0){
                evenNumbers.add(testNumber);
            }
        }
        return evenNumbers;
    }
}
