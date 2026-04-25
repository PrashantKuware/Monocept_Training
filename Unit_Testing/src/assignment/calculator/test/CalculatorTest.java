package assignment.calculator.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import assignment.calculator.model.Calculator;

class CalculatorTest 
{
	
	Calculator calc = new Calculator();
	@Test
	void addTest() 
	{
		assertEquals(10, calc.add(5, 5));
        assertEquals(0, calc.add(5, -5));
        assertEquals(-10, calc.add(-5, -5));
        assertNotEquals(11, calc.add(5, 5));
		
	}
	@Test
	void subtractTest() 
	{
		
		 assertEquals(0, calc.subtract(5, 5));
	        assertEquals(10, calc.subtract(5, -5));
	        assertEquals(0, calc.subtract(0, 0));
	        assertNotEquals(6, calc.subtract(10, 5));
	}
	@Test
	void multiplyTest() 
	{
		assertEquals(25, calc.multiply(5, 5));
        assertEquals(-25, calc.multiply(5, -5));
        assertEquals(25, calc.multiply(-5, -5));
        assertEquals(0, calc.multiply(5, 0));
        assertNotEquals(30, calc.multiply(5, 5));
	}
	@Test
	void divideTest() 
	{
		
		 assertEquals(5, calc.divide(10, 2));
	        assertEquals(-5, calc.divide(10, -2));
	        assertEquals(5, calc.divide(-10, -2));
	        assertNotEquals(4, calc.divide(10, 2));
	}
	 @Test
	    void testDivideByZero() {
	        assertThrows(IllegalArgumentException.class, () -> {
	            calc.divide(10, 0);
	        });
	    }
	 
//   ****************************************************Parametrize Test Starts Here **************************************

	 @ParameterizedTest
	    @CsvSource({
	        "2, 3, 5",
	        "5, 5, 10",
	        "-2, -3, -5",
	        "5, -5, 0"
	    })
	    void testAdd(int a, int b, int expected) {
	        assertEquals(expected, calc.add(a, b));
	    }
//	 ----------------------------------------------

	 @ParameterizedTest
	 @ValueSource(ints = {0, 1, -1, 10})
	 void testMultiplyWithZero(int input) {
	     Calculator calc = new Calculator();
	     assertEquals(0, calc.multiply(input, 0));
	 }
	 
//	 ----------------------------------------------
	 
	 @ParameterizedTest
	 @MethodSource("provideAddData")
	 void testAdd_MethodSource(int a, int b, int expected) {
	     Calculator calc = new Calculator();
	     assertEquals(expected, calc.add(a, b));
	 }

	 static Stream<Arguments> provideAddData() {
	     return Stream.of(
	         Arguments.of(2, 3, 5),
	         Arguments.of(5, 5, 10),
	         Arguments.of(-2, -3, -5),
	         Arguments.of(5, -5, 0)
	     );
	 }
}


