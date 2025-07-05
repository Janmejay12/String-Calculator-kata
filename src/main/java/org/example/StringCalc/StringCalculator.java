package org.example.StringCalc;

public class StringCalculator {
    public int add(String numbers){
        if(isEmpty(numbers)){
            return 0;
        }
        String[] parsedNumbers = parseNumbers(numbers);
        return calculateSum(parsedNumbers);

    }
    private boolean isEmpty(String numbers){
        return numbers.isEmpty();
    }

    private String[] parseNumbers(String numbers){
        if (numbers.startsWith(",") || numbers.startsWith("\n") || numbers.endsWith(",") || numbers.endsWith("\n")) {
            throw new IllegalArgumentException("Input cannot end with a delimiter");
        }
        return numbers.split(",|\n");
    }

    private int calculateSum(String[] numberArray){
        int sum = 0;
        for(String number : numberArray){
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
