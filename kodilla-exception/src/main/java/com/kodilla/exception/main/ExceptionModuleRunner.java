package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.SecondChallenge;

public class ExceptionModuleRunner {
    public static void main(String args[]){

        FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();
        SecondChallenge secondChallenge = new SecondChallenge();

        try{
            fileReader.readFile();
        } catch(FileReaderException e){
            System.out.println("Problem while reading a file!");
        }

        try{
            secondChallenge.probablyIWillThrowException(2,1.5 );
        } catch (ExceptionHandling e){
            System.out.println("It should be like that");
        }
    }
}
