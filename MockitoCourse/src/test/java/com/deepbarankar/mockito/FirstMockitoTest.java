package com.deepbarankar.mockito;

import static org.junit.Assert.*;

import org.junit.Test;

//TodoService.java => It is an interface and an dependency of TodoBusinessImpl. It can be talking to a database or an external interface.
//public List<String> retrieveTodos(String user);

//TodoBusinessImpl.java => This contains the business logic that we want to test
//public List<String> retrieveTodoRelatedToSpring(String user);

// TodoService retrieves todos from the user and TodoBusinessImpl filters the Spring related todos.
//TodoBusinessImpl => SUT [System Under Test]
//TodoService => Dependency [TodoService here is an interface. But it can be developed by some other team or some external interface (Some web service)]
//Here we will see how we will be able to test TodoBusinessImpl without TodoService implementation not being available.

//Create TodoServiceStub
//Test TodoBusinessImpl using TodoServiceStub

public class FirstMockitoTest {

	@Test
	public void test() {
		assertTrue(true);
	}

}
