package com.deepbarankar.mockito;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

//Hamcrest library makes the code more readable.
//Hemcrest library adds many useful asserting matchers.

public class HamcrestMatchersTest {

	@Test
	public void test() {
		List<Integer> scores = Arrays.asList(99, 100, 101, 105);
		//scores has 4 items
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(99, 100));
		
		//every item : > 90
		assertThat(scores, everyItem(greaterThan(90)));
		//every item : < 110
		assertThat(scores, everyItem(lessThan(110)));
		
		//String
		assertThat("", isEmptyString());
		assertThat(null, isEmptyOrNullString());
		
		//Arrays
		Integer[] marks = {1, 2, 3};
		assertThat(marks, arrayWithSize(3));
		assertThat(marks, arrayContaining(1, 2, 3));
		assertThat(marks, arrayContainingInAnyOrder(1, 2, 3));
	}

}
