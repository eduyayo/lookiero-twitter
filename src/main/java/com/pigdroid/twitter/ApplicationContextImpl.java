package com.pigdroid.twitter;

import com.pigdroid.twitter.service.ApplicationService;
import com.pigdroid.twitter.service.MessageService;
import com.pigdroid.twitter.service.UserFollowsService;
import com.pigdroid.twitter.service.UserService;
import com.pigdroid.util.CollectionStore;

public class ApplicationContextImpl implements ApplicationContext {

	private CollectionStore store = null;
	private UserService userService = null;
	private UserFollowsService userFollowsService = null;
	private MessageService messageService = null;
	private ApplicationService applicationService = null;

	@Override
	public CollectionStore getStore() {
		if (store == null) {
			store = new CollectionStore();
		}
		return store;
	}

	@Override
	public UserFollowsService getUserFollowsService() {
		if (userFollowsService == null) {
			userFollowsService = new UserFollowsService(getStore());
		}
		return userFollowsService;
	}

	@Override
	public MessageService getMessageService() {
		if (messageService == null) {
			messageService = new MessageService(getStore());
		}
		return messageService;
	}

	@Override
	public UserService getUserService() {
		if (userService == null) {
			userService = new UserService(getStore());
		}
		return userService;
	}

	@Override
	public ApplicationService getApplicationService() {
		if (applicationService == null) {
			applicationService = new ApplicationService(this);
		}
		return applicationService;
	}

}
