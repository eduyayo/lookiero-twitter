package com.pigdroid.twitter;

import com.pigdroid.twitter.service.ApplicationService;
import com.pigdroid.twitter.service.MessageService;
import com.pigdroid.twitter.service.UserFollowsService;
import com.pigdroid.twitter.service.UserService;
import com.pigdroid.util.CollectionStore;

public interface ApplicationContext {

	UserFollowsService getUserFollowsService();

	CollectionStore getStore();

	MessageService getMessageService();

	UserService getUserService();

	ApplicationService getApplicationService();

}
