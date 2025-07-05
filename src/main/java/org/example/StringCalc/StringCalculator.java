package org.example.StringCalc;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|\n";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String NEGATIVE_NUMBERS_NOT_ALLOWED = "negative numbers not allowed ";

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
        String delimiter = Pattern.quote(parts[0].substring(2)); // Escape delimiter for regex
        String numbersPart = parts[1];
        return new DelimiterInfo(delimiter, numbersPart);
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
            sum += Integer.parseInt(number.trim());
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
