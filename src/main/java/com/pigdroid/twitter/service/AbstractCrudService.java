package com.pigdroid.twitter.service;

import java.util.stream.Stream;

import com.pigdroid.twitter.model.BaseEntity;
import com.pigdroid.util.CollectionStore;

public abstract class AbstractCrudService<T extends BaseEntity> {

	private Class<T> clazz;
	private CollectionStore store;

	protected AbstractCrudService(CollectionStore store, Class<T> clazz) {
		this.clazz = clazz;
		this.store = store;
	}

	public void create(T t) {
		store.add(t);
	}

	public boolean createIfNotExists(T t) {
		boolean ret = false;
		boolean mathed = this.all().anyMatch(each -> isTheSame(t, each));
		if (!mathed) {
			create(t);
			ret = true;
		}
		return ret;
	}

	protected abstract boolean isTheSame(T one, T other);

	protected Stream<T> all() {
		return store.get(clazz);
	}

}
