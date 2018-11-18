package com.kodilla.stream.beautifier;

public class FunctionalBeautifier {
    public static String addABCOnEnd(String string) {
        return string+"ABC";
    }

    public static String addABCOnBegin(String string) {
        return "ABC"+string;
    }

    public static String everyEvenLetterUpperCase(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            if (i % 2 == 1) {
                result += string.substring(i, i + 1).toUpperCase();
            } else {
                result += string.substring(i, i + 1);
            }
        }
        return result;
    }

    public static String numberAfterEveryLetter(String string){
        String result ="";
        for(int i=0; i<string.length();i++){
            result+=string.substring(i,i+1)+i;
        }
        return result;
    }

}

