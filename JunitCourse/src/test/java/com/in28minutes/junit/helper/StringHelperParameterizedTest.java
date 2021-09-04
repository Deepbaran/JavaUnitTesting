package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {
	// Parameterized Test - A test that runs with a few parameters.
	// We cannot have two parameterized tests in the same class.
	// So for a different parameterized test we will need another class.
	
	StringHelper helper = new StringHelper();
	
	public StringHelperParameterizedTest(String input, String expectedOutput) {
		// AACD is the input and CD is the expectedOutput for the first element in the collection.
		// ACD is the input and CD is the expectedOutput for the second element in the collection.
		// The test method will check for each and every element.
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	private String input;
	private String expectedOutput;
	
	@Parameters
	public static Collection<String[]> testConditions() {
		// Defining the actual parameters.
		//  Here we will return the parameters as Collection to the constructor of this class.
		// Each test condition is returned as element in the Collection.
		String[][] expectedOutputs = {
				{"AACD", "CD"},
				{"ACD", "CD"}};
		return Arrays.asList(expectedOutputs);
	}
	
//	@Test
//	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
//		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
//	}
//
//	@Test
//	public void testTruncateAInFirst2Positions_AinFirstPosition() {
//		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
//	}
	
	@Test
	public void testTruncateAInFirst2Positions() {
		assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
	}

}

/*
 * @RunWith(Parameterized.class) - This annotates that the tests inside the class will not run in a normal way and all the tests must be Parameterized Tests.
 * 
 * @Parameters - Annotation for a method which provides parameters to be injected into the test class constructor by Parameterized. The method has tobe public and static. 
*/