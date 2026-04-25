package assignment.array_reverse.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import assignment.array_reverse.model.ReverseArrayClass;

public class ReverseArrayClassTest 
{
	ReverseArrayClass temp = new ReverseArrayClass();
	
	@Test
	public void testNormalArray()
	{
		int[] actual = {1,2,3,4};
		int[] expected = {4,3,2,1};
		assertArrayEquals(expected, temp.reverseArray(actual));
	}
	
	@Test
	public void testSingleElement()
	{
		int[] actual = {4};
		int[] expected = {4};
		assertArrayEquals(expected, temp.reverseArray(actual));
	}
	
	@Test
	public void testEmptyArray()
	{
		int[] actual = {};
		int[] expected = {};
		assertArrayEquals(expected, temp.reverseArray(actual));
	}
	
	 @Test
	    void testNullArray() {
	        assertNull(temp.reverseArray(null));
	    }
}
