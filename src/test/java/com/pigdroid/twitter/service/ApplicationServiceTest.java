package com.pigdroid.twitter.service;

import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.pigdroid.twitter.ApplicationContext;
import com.pigdroid.twitter.model.User;
import com.pigdroid.util.console.ConsoleWriter;

public class ApplicationServiceTest {

	@InjectMocks
	ApplicationService fixture;

	@Mock(answer = Answers.RETURNS_MOCKS)
	ApplicationContext applicationContext;

	@Mock
	UserService userService;

	@Mock
	UserFollowsService userFollowsService;

	@Mock
	MessageService messageService;

	@Mock
	ConsoleWriter consoleWriter;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(applicationContext.getUserService()).thenReturn(userService);
		when(applicationContext.getUserFollowsService()).thenReturn(userFollowsService);
		when(applicationContext.getMessageService()).thenReturn(messageService);
	}

	@Test
	public void testAddUserFollowWithoutErrors() {
		fixture.addUserFollow("tete", "cohete");
		ArgumentCaptor<User> captor = forClass(User.class);
		InOrder inOrder = inOrder(userService, userFollowsService);
		inOrder.verify(userService, times(2)).createIfNotExists(captor.capture());
		inOrder.verify(applicationContext.getUserFollowsService(), times(1)).createIfNotExists(Mockito.any());
	}

	@Test
	public void testPostMessageWithoutErrors() {
		fixture.postMessage("tete", "cohete");
		ArgumentCaptor<User> captor = forClass(User.class);
		InOrder inOrder = inOrder(userService, messageService);
		inOrder.verify(userService, times(1)).createIfNotExists(captor.capture());
		inOrder.verify(messageService, times(1)).create(Mockito.any());
	}

	@Test
	public void testShowUserMessagesWithoutErrors() {
		fixture.showUserMessages("tete", consoleWriter);
		ArgumentCaptor<User> captor = forClass(User.class);
		InOrder inOrder = inOrder(userService, messageService);
		inOrder.verify(userService, times(1)).createIfNotExists(captor.capture());
		inOrder.verify(messageService, times(1)).findByUsers(Mockito.any());
	}

	@Test
	public void testShowUserWallWithoutErrors() {
		fixture.showUserWall("tete", consoleWriter);
		ArgumentCaptor<User> captor = forClass(User.class);
		InOrder inOrder = inOrder(userService, messageService, userFollowsService);
		inOrder.verify(userService, times(1)).createIfNotExists(captor.capture());
		inOrder.verify(userFollowsService, times(1)).findUserFollows(Mockito.anyString());
		inOrder.verify(messageService, times(1)).findByUsers(Mockito.any());
	}

}
