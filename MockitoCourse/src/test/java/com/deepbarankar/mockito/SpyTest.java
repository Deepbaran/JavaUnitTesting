package com.deepbarankar.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
//		List arrayListMock = mock(ArrayList.class);
//		assertEquals(0, arrayListMock.size());
		
		//mock return default value
//		arrayListMock.add("Dummy");
		//This will not change the value the size of the arrayListMock
		//That is because, we are not interacting with a real ArrayList class object at all.
		//We are interacting with a mock object of the ArrayList class.
		//So, here we are inserting it into a mock.
		//Mock is a dummy implementation.
		//There will not be any real logic from the ArrayList Class that is being used.
		//For this to work, we need to use a spy. As spy gets all logic from the Class.
		
//		stub(arrayListMock.size()).toReturn(5);
//		assertEquals(5, arrayListMock.size());
		
		// Using SPY
		List arrayListSpy = spy(ArrayList.class); //It's almost like we are creating a real ArrayList object but we can still override particular methods using stub
		assertEquals(0, arrayListSpy.size());
		arrayListSpy.add("Dummy");
		verify(arrayListSpy).add("Dummy"); //Verify that "Dummy" was really added to the arrayListSpy
		verify(arrayListSpy, never()).clear(); //Verify that the clear method was never called on arrayListSpy
		assertEquals(1, arrayListSpy.size());
		stub(arrayListSpy.size()).toReturn(5); //Overriding the size() method of the ArrayList Class using stub
		assertEquals(5, arrayListSpy.size());
	}

}
