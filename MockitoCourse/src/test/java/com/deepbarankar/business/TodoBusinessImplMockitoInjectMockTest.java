package com.deepbarankar.business;

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

import com.deepbarankar.data.api.TodoService;

//@RunWith(MockitoJUnitRunner.class) // This runner allows us to use the Mockito annotations.
public class TodoBusinessImplMockitoInjectMockTest {
	
	// If some framework uses runner [@RunWith] then using the runner of JUnit will not be possible. As we can only have one runner.
	// To overcome this, JUnit uses @Rule [Introduced in JUnit 4.7].
	// We can have multiple rules in one test class.
	// Similar to a runner, the rule will run before and after the test.
	// The rules must be public, so that other frameworks can access them.
	// Prefer @Rule over @RunWith
	
	// Specific rule for the Mockito
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
//	@Rule
//	public MockitoRule mockitoRule = MockitoJUnit.rule();

	@Mock
	TodoService todoServiceMock; //TodoService todoServiceMock = mock(TodoService.class);
	// A Mock object is automatically created due to the @Mock annotation.
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl; //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
	//Mockito will go into the TodoBusinessImpl class and see if any of the dependencies match the Mock, if it does, then Mockito will inject the mock.
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	//Creates a Argument Captor.

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock1() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(allTodos);

		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(2, todos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingMock2() {

		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn to Dance");
		when(todoServiceMock.retrieveTodos("Dummy2")).thenReturn(allTodos);

		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy2");

		assertEquals(1, todos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {

		// Given
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy3")).willReturn(allTodos);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy3");

		// Then
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {

		// Given
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance", "Learn to Sing");

		given(todoServiceMock.retrieveTodos("Dummy4")).willReturn(allTodos);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy4");

		// Then
		then(todoServiceMock).should().deleteTodo("Learn to Dance");

		verify(todoServiceMock, times(1)).deleteTodo("Learn to Sing");

		verify(todoServiceMock, atLeastOnce()).deleteTodo("Learn to Sing");

		verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Sing");

		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {

		// Given
		List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

		given(todoServiceMock.retrieveTodos("Dummy5")).willReturn(allTodos);

		// When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy5");

		// Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

		assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {
		
		//Given
		List<String> allTodos = Arrays.asList("Learn to Rock and Roll",
				"Learn Spring", "Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy5")).willReturn(allTodos);
		
		//When
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy5");
		
		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
	}

}

/*
 * @Mock - Mckito automatically creates Mock of the following kind.
 * 
 * @InjectMocks - This will look into all the dependencies of the class and checks if any matches the created Mock and automatically inject it in.
 * 
 * @Captor - Creates Argument Captors.
 * 
 * @RunWith(MockitoJUnitRunner.class) - This runner allows us to use the Mockito annotations.
 */
