package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	StringHelper helper;
	
	@Before
	public void before() {
		// Now each of the test case will be running with the help of a new instance of StringHelper
		helper = new StringHelper();
	}

	/*
	 * @Test public void test() { // assertEquals("ABC", "ABCD"); // expected,
	 * actual // expected is the value that we are expecting to come out after the
	 * operation. // actual is the value that comes out after whatever operation we
	 * want to do or after calling a method. // expected:<ABC[]> but was:<ABC[D]>
	 * 
	 * // assertEquals("ABC", "ABC");
	 * 
	 * // String actual = helper.truncateAInFirst2Positions("AACD"); // String
	 * expected = "CD"; // assertEquals(expected, actual);
	 * 
	 * assertEquals("CD", helper.truncateAInFirst2Positions("AACD")); //
	 * assertEquals("ACD", helper.truncateAInFirst2Positions("CD"));
	 * //org.junit.ComparisonFailure: expected:<[A]CD> but was:<[]CD>
	 * assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	 * assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
	 * assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA")); }
	 */
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
		// Don't have more than one Condition in a Unit test.
		// For multiple conditions, we will need to create another test. It helps us to figure out exactly for which test condition the test failed.
		// When we highlight a particular test method and run it then only that test condition is checked.
		// The test function should be public void. Because some framework should be able to call it and the framework will be in a different package.
		// test method naming convention: @Test public void test<methodName>_testCondition() {}
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
//		assertEquals(false, helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		
//		assertFalse("test failed", helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		//str, actualValue
		//str - value that is printed when the test fails
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}

}

/*
 * @Test - This annotation comes from the org.junit.Test. It annotates that the following method is a specific unit test method. Make sure to give a specific name
 * to the following method so that it is clear for which method the test is going to run.
 * 
 * @Before - This annotation is used whenever we have some things to do before a test. The method under @Before will get executed before each and every test.
 * 
 * @After - This annotation is used whenever we have some things to do after a test. The method under @After will get executed after each and every test.
 * 
 * @BeforeClass - This annotation is used whenever we have some things to do before any test runs. It only runs once in the whole class. Any class implementing it must be static.
 * 
 * @AfterClass - This annotation is used whenever we have some things to do after all test has run. It only runs once in the whole class. Any class implementing it must be static.
 * 
 * fail() - It is one of the methods in a series of assert methods that JUnit provides. A fail() would normally fail a test.
 * 
 * assertEquals(expected, actual) - It checks if expected and the actual value are equal or not. The test fails if the values do not match.
 * 
 * assertTrue(str, actual) - It checks if the value of the actual is true or not. If not then the test case fails and str is shown. str is not needed in modern ide.
 * 
 * assertFalse(str, actual) - It checks if the value of the actual is false or not. If not then the test case fails and str is shown. str is not needed in modern ide.
 */