package org.example.StringCalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEGATIVE_NUMBERS_NOT_ALLOWED = "negative numbers not allowed ";

    /**
     * Calculates the sum of numbers from a comma-separated string.
     * Supports custom delimiters and validates against negative numbers.
     *
     * @param numbers the input string containing numbers
     * @return the sum of all numbers
     * @throws IllegalArgumentException if negative numbers are provided
     */

    public int add(String numbers) {
        if (isEmpty(numbers)) {
            return 0;
        }

        DelimiterInfo delimiterInfo = extractDelimiterInfo(numbers);
        String[] parsedNumbers = parseNumbers(delimiterInfo.getNumbers(), delimiterInfo.getDelimiter());
        validateNoNegativeNumbers(parsedNumbers);
        return calculateSum(parsedNumbers);
    }

    private boolean isEmpty(String numbers) {
        return numbers.isEmpty();
    }

    private DelimiterInfo extractDelimiterInfo(String numbers) {
        if (hasCustomDelimiter(numbers)) {
            return parseCustomDelimiter(numbers);
        }
        return new DelimiterInfo(DEFAULT_DELIMITER, numbers);
    }

    private boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private DelimiterInfo parseCustomDelimiter(String numbers) {
        String[] parts = numbers.split("\n", 2);
        String delimiterPart = parts[0].substring(2); // Remove "//"
        String numbersPart = parts[1];

        String delimiter;
        if (delimiterPart.startsWith("[")) {
            // Handle bracketed delimiter format: //[delimiter]\n or //[delim1][delim2]\n
            delimiter = parseMultipleDelimiters(delimiterPart);
        } else {
            // Handle simple delimiter format: //delimiter\n
            delimiter = Pattern.quote(delimiterPart);
        }

        return new DelimiterInfo(delimiter, numbersPart);
    }

    private String parseMultipleDelimiters(String delimiterPart) {
        List<String> delimiters = new ArrayList<>();
        int start = 0;

        while (start < delimiterPart.length()) {
            int openBracket = delimiterPart.indexOf('[', start);
            int closeBracket = delimiterPart.indexOf(']', openBracket);

            if (openBracket == -1 || closeBracket == -1) {
                break;
            }

            String delimiter = delimiterPart.substring(openBracket + 1, closeBracket);
            delimiters.add(Pattern.quote(delimiter));
            start = closeBracket + 1;
        }

        return String.join("|", delimiters);
    }

    private String[] parseNumbers(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private void validateNoNegativeNumbers(String[] numberArray) {
        List<String> negativeNumbers = collectNegativeNumbers(numberArray);
        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException(NEGATIVE_NUMBERS_NOT_ALLOWED + String.join(",", negativeNumbers));
        }
    }

    private List<String> collectNegativeNumbers(String[] numberArray) {
        List<String> negativeNumbers = new ArrayList<>();
        for (String number : numberArray) {
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber < 0) {
                negativeNumbers.add(number.trim());
            }
        }
        return negativeNumbers;
    }

    private int calculateSum(String[] numberArray) {
        int sum = 0;
        for (String number : numberArray) {
            int parsedNumber = Integer.parseInt(number.trim());
            if (parsedNumber <= 1000) {
                sum += parsedNumber;
            }
        }
        return sum;
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
