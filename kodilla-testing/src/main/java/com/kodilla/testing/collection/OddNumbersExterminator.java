package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    List<Integer> exterminate(List<Integer> numbers){
        List<Integer> evenNumbers = new ArrayList<Integer>();
        for(int i=0; i<numbers.size();i++){
            int testNumber = numbers.get(i);
            if(testNumber%2==0){
                evenNumbers.add(testNumber);
            }
        }
        return evenNumbers;
    }
}
