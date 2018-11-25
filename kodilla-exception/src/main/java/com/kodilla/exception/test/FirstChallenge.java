package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException{
        double result = 0;
        try {
            if (b == 0) {
                result = a/b;
                throw new ArithmeticException();
            } else {
                result = a / b;
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by 0. Result is infinity");
        } finally {
            System.out.println("Dividiation is complete");
        }
        return result;
    }

//    public double divide(double a, double b) throws ArithmeticException {
//        if(b == 0){
//            throw new ArithmeticException();
//        }
//        return a / b;
//    }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);

        System.out.println(result);

    }
}