package org.example.StringCalc;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String numbers){
        if(isEmpty(numbers)){
            return 0;
        }
        DelimiterInfo delimiterInfo = extractDelimiterInfo(numbers);
        String[] parsedNumbers = parseNumbers(delimiterInfo.getNumbers(), delimiterInfo.getDelimiter());
        return calculateSum(parsedNumbers);

    }
    private boolean isEmpty(String numbers){
        return numbers.isEmpty();
    }

    private DelimiterInfo extractDelimiterInfo(String numbers) {
        if (hasCustomDelimiter(numbers)) {
            return parseCustomDelimiter(numbers);
        }
        return new DelimiterInfo(",|\n", numbers);
    }

    private DelimiterInfo parseCustomDelimiter(String numbers) {
        String[] parts = numbers.split("\n", 2);
        String delimiter = parts[0].substring(2); // Remove "//"
        String numbersPart = parts[1];
        return new DelimiterInfo(delimiter, numbersPart);
    }

    private boolean hasCustomDelimiter(String numbers) {
        return (numbers.startsWith("//") && numbers.charAt(3) == '\n');
    }


    private String[] parseNumbers(String numbers, String delimeter){
        if (numbers.startsWith(",") || numbers.startsWith("\n") || numbers.endsWith(",") || numbers.endsWith("\n")) {
            throw new IllegalArgumentException("Input cannot end with a delimiter");
        }
        return numbers.split(delimeter);
    }

    private int calculateSum(String[] numberArray){
        validateNoNegativeNumber(numberArray);
        int sum = 0;
        for(String number : numberArray){
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private void validateNoNegativeNumber(String[] numberArray){
        for(String number : numberArray){
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("negative numbers not allowed " + parsedNumber);
            }
        }

    }

    private static class DelimiterInfo {
        private final String delimiter;
        private final String numbers;

        public DelimiterInfo(String delimiter, String numbers) {
            this.delimiter = delimiter;
            this.numbers = numbers;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getNumbers() {
            return numbers;
        }
    }
}
