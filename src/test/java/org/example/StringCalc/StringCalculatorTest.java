package org.example.StringCalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    public void emptyStringReturnsZero(){
        int result = calculator.add("");
        assertEquals(0, result);
    }
    @Test
    public void should_return_number_for_single_number(){
        int result = calculator.add("1");
        assertEquals(1, result);
        result = calculator.add("9");
        assertEquals(9, result);
        result = calculator.add("99");
        assertEquals(99, result);
    }

    @Test
    public void should_return_sum_for_two_numbers(){
        int result = calculator.add("1,9");
        assertEquals(10, result);
    }

    @Test
    public void should_return_sum_for_multiple_numbers(){
        int result = calculator.add("1,2,3,4,5");
        assertEquals(15, result);
    }

    @Test
    public void should_return_sum_for_various_multiple_numbers(){
        int result = calculator.add("0,5,0");
        assertEquals(5, result);
        result = calculator.add("3,3,3");
        assertEquals(9, result);
    }

    @Test
    public void should_handle_newlines_between_numbers(){
        int result = calculator.add("1,2\n3");
        assertEquals(6, result);
    }

    @Test
    public  void should_handle_custom_delimiter(){
        int result = calculator.add("//;\n1;2");
        assertEquals(3, result);
    }

    @Test
    public void should_handle_custom_delimiter_with_multiple_numbers() {
        int result = calculator.add("//|\n1|2|3");
        assertEquals(6, result);
    }

    @Test
    public void should_handle_regex_special_character_delimiter() {
        int result = calculator.add("//+\n1+2+3");
        assertEquals(6, result);
    }

    @Test
    public void should_throw_exception_for_negative_number(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3");
        });
        assertEquals("negative numbers not allowed -2", exception.getMessage());
    }

    @Test
    public void should_throw_exception_for_multiple_negative_numbers() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertEquals("negative numbers not allowed -2,-4", exception.getMessage());
    }

    @Test
    public void should_ignore_numbers_bigger_than_1000() {
        int result = calculator.add("2,1001");
        assertEquals(2, result);
    }

    @Test
    public void should_ignore_multiple_numbers_bigger_than_1000() {
        int result = calculator.add("1,2,1001,1002,3");
        assertEquals(6, result);
    }

    @Test
    public void should_handle_multiple_single_char_delimiters() {
        int result = calculator.add("//[*][%]\n1*2%3");
        assertEquals(6, result);
    }

    @Test
    public void should_handle_delimiter_of_any_length() {
        int result = calculator.add("//[***]\n1***2***3");
        assertEquals(6, result);
    }

    @Test
    public void should_handle_long_delimiter_with_special_characters() {
        int result = calculator.add("//[!!@]\n1!!@2!!@3");
        assertEquals(6, result);
    }

}
