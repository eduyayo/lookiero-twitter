package com.pigdroid.twitter.service;

import com.pigdroid.twitter.model.User;
import com.pigdroid.util.CollectionStore;

public class UserService extends AbstractCrudService<User> {

	public UserService(CollectionStore store) {
		super(store, User.class);
	}

	@Override
	protected boolean isTheSame(User one, User other) {
		return one.getName()
				.equalsIgnoreCase(other.getName());
	}

}
