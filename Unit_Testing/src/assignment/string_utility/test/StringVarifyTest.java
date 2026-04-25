package assignment.string_utility.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import assignment.string_utility.model.StringVarify;

class StringVarifyTest {
	
	StringVarify util = new StringVarify();
	@Test
    void testIsEmpty() 
	{
        assertTrue(util.isEmptycheck(null));        
        assertTrue(util.isEmptycheck(""));          
        assertFalse(util.isEmptycheck(" "));        
        assertFalse(util.isEmptycheck("Hello"));    
    }

    
    @Test
    void testToUpperCase() {
        assertNull(util.toUpperCase(null));                
        assertNotNull(util.toUpperCase("abc"));             
        assertEquals("ABC", util.toUpperCase("abc"));       
        assertEquals("", util.toUpperCase(""));             
        assertEquals(" ", util.toUpperCase(" "));          
    }

   
    @Test
    void testGetLength() {
        assertNull(util.getLength(null));       
        assertNotNull(util.getLength("Hi"));    
        assertEquals(0, util.getLength(""));    
        assertEquals(1, util.getLength(" "));   
        assertEquals(5, util.getLength("Hello")); 
    }
    
//    ****************************************************Parametrize Test Starts Here **************************************
    
    @ParameterizedTest
    @CsvSource({
        "hello, HELLO",
        "java, JAVA",
        "'', ''"
    })
    void testToUpperCase(String input, String expected) {
    	
        assertEquals(expected, util.toUpperCase(input));
    }
//    -------------------------------------------------
    @ParameterizedTest
    @NullAndEmptySource
    void testNullAndEmpty(String input) {
        assertTrue(input == null || input.isEmpty());
    }
//  -------------------------------------------------

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " ", "das"})
    void testAllCases(String input) {
        assertTrue(input == null || input.isEmpty());
    }
//  -------------------------------------------------

    @ParameterizedTest
    @MethodSource("provideStringData")
    void testLength_MethodSource(String input, Integer expected) {
       
        assertEquals(expected, util.getLength(input));
    }

    static Stream<Arguments> provideStringData() {
        return Stream.of(
            Arguments.of("Hello", 5),
            Arguments.of("", 0),
            Arguments.of(" ", 1),
            Arguments.of(null, null)
        );
    }
}
