package com.kodilla.stream;

import com.kodilla.stream.beautifier.FunctionalBeautifier;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Beautifin texts with lambdas");
        poemBeautifier.beautify("kodilla", (String) -> String+"ABC");
        poemBeautifier.beautify("kodilla", (String) -> "ABC"+String);

        System.out.println("Beautifing texts with method references");
        poemBeautifier.beautify("kodilla", FunctionalBeautifier::addABCOnEnd);
        poemBeautifier.beautify("kodilla", FunctionalBeautifier::addABCOnBegin);
        poemBeautifier.beautify("kodilla", FunctionalBeautifier::everyEvenLetterUpperCase);
        poemBeautifier.beautify("kodilla", FunctionalBeautifier::numberAfterEveryLetter);
    }
}