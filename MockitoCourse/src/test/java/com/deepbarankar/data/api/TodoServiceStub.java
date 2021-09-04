package com.deepbarankar.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learning Spring MVC", "Learning Spring", "Learn to Dance");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
