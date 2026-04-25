package com.Junit_01.test;

import org.junit.jupiter.api.Test;

import com.Junit_01.model.Shapes;

class ShapesTest {

	Shapes shape = new Shapes();
	@Test
	void computeSqureArea() 
	{
		assertEquals(576, shape.computeSqureShape(24));
	}

}
