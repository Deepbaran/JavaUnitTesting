package com.deepbarankar.powermock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.deepbarankar.data.api.TodoService;

@RunWith(PowerMockRunner.class) //Runner for PowerMock
@PrepareForTest(UtilityClass.class) // Class containing the static method to be mocked
public class MockingStaticMethodTest {
	
	//Steps to use powermock for Static methods:
	//1. Specific Runner
	//2. Initialize the class which has the static methods (UtilityClass.class) for mocking
	//3. Mock the specific method
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	Dependency dependency;
	
	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock1() {

		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(dependency.retrieveAllStats()).thenReturn(stats);
		
		//Initialize the UtilityClass.class for mocking
		PowerMockito.mockStatic(UtilityClass.class);
		
		when(UtilityClass.staticMethod(6)).thenReturn(150);
		
		int result = systemUnderTest.methodCallingAStaticMethod();
		//When methodCallingAStaticMethod method is called, it is calling the staticMethod method of the UtilityClass in it's code.
		//The staticMethod is being mocked and is supposed to return 150.
		
		assertEquals(150, result);
		
		//Verify if a method was called or not in PowerMockito
		//Two Steps:
		//1. PowerMockito.verifyStatic()
		//2. Actual Static Method call to verify
		PowerMockito.verifyStatic();
//		UtilityClass.staticMethod(5); //This will fail, as in the mock, we are calling this static method with a argument of 6 and not a 5.
		UtilityClass.staticMethod(6);
	}

}

/*
 * For mocking Static Methods in PowerMock:
 * @RunWith
 * @PrepareForTest
 * PowerMockito.mockStatic()
 */