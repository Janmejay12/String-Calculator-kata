package org.example.StringCalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void emptyStringReturnsZero(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("");
        assertEquals(0, result);
    }
    @Test
    public void should_return_number_for_single_number(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1");
        assertEquals(1, result);
        result = calculator.add("9");
        assertEquals(9, result);
        result = calculator.add("99");
        assertEquals(99, result);
    }

    @Test
    public void should_return_sum_for_two_numbers(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,9");
        assertEquals(10, result);
    }

    @Test
    public void should_return_sum_for_multiple_numbers(){
        StringCalculator calculator = new StringCalculator();
        int result = calculator.add("1,2,3,4,5");
        assertEquals(15, result);
    }


}
