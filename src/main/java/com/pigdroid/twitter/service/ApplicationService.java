package com.pigdroid.twitter.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import com.pigdroid.twitter.ApplicationContext;
import com.pigdroid.twitter.model.Message;
import com.pigdroid.twitter.model.User;
import com.pigdroid.twitter.model.UserFollows;
import com.pigdroid.util.StringUtils;
import com.pigdroid.util.console.ConsoleWriter;

public class ApplicationService {

	private static final String MESSAGE_FORMAT_STRING = "%s: %s (%s)";
	private ApplicationContext context;

	public ApplicationService(ApplicationContext context) {
		this.context = context;
	}

	public void addUserFollow(String sourceUser, String targetUser) {
		this.context.getUserService().createIfNotExists(
				User.builder()
					.withName(sourceUser)
					.build());
		this.context.getUserService().createIfNotExists(
				User.builder()
					.withName(targetUser)
					.build());
		this.context.getUserFollowsService().createIfNotExists(
				UserFollows.builder()
				.withFollows(targetUser)
				.withUser(sourceUser)
				.build());
	}

	public void postMessage(String userName, String line) {
		this.context.getUserService().createIfNotExists(
				User.builder()
					.withName(userName)
					.build());
		this.context.getMessageService().create(
				Message.builder()
					.withUserName(userName)
					.withContents(line)
					.build());
	}

	public void showUserMessages(String userName, ConsoleWriter out) {
		this.context.getUserService().createIfNotExists(
				User.builder()
					.withName(userName)
					.build());
		this.context.getMessageService()
			.findByUsers(new HashSet<>(Arrays.asList(userName)))
			.forEach(each -> printMessage(out, each));
	}

	public void showUserWall(String userName, ConsoleWriter out) {
		this.context.getUserService().createIfNotExists(
				User.builder()
					.withName(userName)
					.build());
		HashSet<String> usersToFilter =
				new HashSet<String>(
						this.context.getUserFollowsService().findUserFollows(userName));
		usersToFilter.add(userName);
		Collection<Message> messages =
				this.context.getMessageService().findByUsers(usersToFilter);
		messages.forEach(each -> printMessage(out, each));
	}

	private void printMessage(ConsoleWriter out, Message message) {
		out.println(String.format(
				MESSAGE_FORMAT_STRING,
				message.getUserName(),
				message.getContents(),
				StringUtils.getTimeAgoString(message.getCreationTime())));
	}

	public void showAllObjects(ConsoleWriter out) {
		out.println("DB Objects listing:");
		this.context.getStore().getAll().forEach(out::println);
		out.println("");
	}

}
