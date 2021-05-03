package com.pigdroid.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class CollectionStoreTest {

	@Test
	public void testCanStoreAndRetrieveAll() {
		CollectionStore fixture = new CollectionStore();
		fixture.add("test");
		fixture.add("this");
		fixture.add("thing");
		List<String> strings = fixture.get(String.class).collect(Collectors.toList());
		assertEquals(strings, fixture.getAll());

		fixture.add(1);
		strings = fixture.get(String.class).collect(Collectors.toList());
		assertNotEquals(strings, fixture.getAll());

	}

}
