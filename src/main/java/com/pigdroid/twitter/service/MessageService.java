package com.pigdroid.twitter.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.pigdroid.twitter.model.Message;
import com.pigdroid.util.CollectionStore;

public class MessageService extends AbstractCrudService<Message> {

	public MessageService(CollectionStore store) {
		super(store, Message.class);
	}

	@Override
	protected boolean isTheSame(Message one, Message other) {
		return false;
	}

	public Collection<Message> findByUsers(Set<String> usersToFilter) {
		Set<String> filter = new HashSet<String>();
		usersToFilter.stream().map(each -> each.toLowerCase()).forEach(filter::add);
		return all()
				.filter(each -> filter.contains(each.getUserName().toLowerCase()))
				.sorted(Message.BY_DATE_COMPARATOR).collect(Collectors.toList());
	}

}
