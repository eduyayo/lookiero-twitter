package com.pigdroid.twitter.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pigdroid.twitter.model.UserFollows;
import com.pigdroid.util.CollectionStore;

public class UserFollowsService extends AbstractCrudService<UserFollows> {

	public UserFollowsService(CollectionStore store) {
		super(store, UserFollows.class);
	}

	@Override
	protected boolean isTheSame(UserFollows one, UserFollows other) {
		return one.getUser().equalsIgnoreCase(other.getUser())
				&& one.getFollows().equalsIgnoreCase(other.getFollows());
	}

	public Stream<UserFollows> findByUser(String userName) {
		return all().filter(each -> each.getUser().equalsIgnoreCase(userName));
	}

	public Collection<String> findUserFollows(String userName) {
		return findByUser(userName)
				.map(each -> each.getFollows())
				.collect(Collectors.toSet());
	}

}
