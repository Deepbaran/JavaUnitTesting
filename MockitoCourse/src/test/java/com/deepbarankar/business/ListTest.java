package com.deepbarankar.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListTest {
	
	@Test
	public void letsMockListSizeMethod() {
		// BDD
		// Given - setup
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		// When - actual method call
		
		// Then - asserts
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	public void letsMockListSizeMethod_ReturnMultipleValues() {
		// Mocking a List Class
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3); //First time it will return a value 2 and the 2nd time it will return a value 3
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void letsMockListGetMethod_ReturnMultipleValues() {
		// Mocking a List Class
		List listMock = mock(List.class);
		
		// Everytime listMock.get(n) is called, "deep" is returned everytime, irrespective of the parameter that is passed (n).
		// So, for stubbing the method for each method, we will need to create that many when().thenReturn(). Which is unrealistic.
		// This is where things like Argument Catcher comes in.
//		when(listMock.get(0)).thenReturn("deep");
//		assertEquals("deep", listMock.get(0)); // listMock.get(0) is stubbed
//		assertEquals(null, listMock.get(1)); // As listMock.get(1) is not stubbed, so the nice mock property will kick in here and a null value will be returned for listMock.get(1)
		
		// Argument Matcher => anyInt(), anyObject(), anyList(), etc.
		when(listMock.get(anyInt())).thenReturn("deep"); // Now listMock.get(n) is stubbed for all parameters (n) and all return "deep".
		assertEquals("deep", listMock.get(0));
		assertEquals("deep", listMock.get(1));
	}
	
	@Test(expected=RuntimeException.class) // This is catching the RuntimeException as it is expected. Without this, the test fails.
	public void letsMockList_throwAnException() {
		// Throwing Exception in Mockito
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something")); // This will throw a RuntimeException for the listMock.get(n) method.
		listMock.get(0);
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_mixingUp() {
		List listMock = mock(List.class);
		
		// This will throw a genuine error because Mockito does not allow a generic and a hard coded value together.
		// So, in Mockito we cannot combine a matcher with a hardcoded value when stubbing.
		// Either you need to be completely generic or very specific.
		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
		listMock.get(0);
	}
	
	@Test
	public void letsMockListGet_usingBDD() {
		// So, Given a mock where everything returns "deep", when we get the first element, we are asserting that the first element is matching our expectations.
		// This is how we structure BDD.
		// Given part uses given().willReturn()
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("deep");
		
		//When
		String firstElement = listMock.get(0);
		
		//Then
		assertThat(firstElement, is("deep"));
	}

}
