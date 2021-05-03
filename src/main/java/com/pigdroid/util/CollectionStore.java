package com.pigdroid.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CollectionStore {

	private Map<Class<Object>, List<Object>> store = new HashMap<>();

	@SuppressWarnings("unchecked")
	public void add(Object in) {
		Class key = in.getClass();
		List<Object> list = store.computeIfAbsent(key, (k) -> new ArrayList<Object>());
		list.add(in);
	}

	public <T> Stream<T> get(Class<T> key) {
		return store.computeIfAbsent((Class<Object>) key, (k) -> new ArrayList<Object>()).stream()
				.filter(each -> each != null)
				.filter(each -> key.isInstance(each))
				.map(each -> key.cast(each));
	}

	public Iterable<Object> getAll() {
		List<Object> ret = new ArrayList<Object>();
		this.store.values().forEach(ret::addAll);
		return ret;
	}

}
