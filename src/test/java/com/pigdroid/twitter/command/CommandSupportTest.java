package com.pigdroid.twitter.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.pigdroid.twitter.command.CommandSupport.Tokenized;

public class CommandSupportTest {

	CommandSupport fixture = new CommandSupport() {

		@Override
		public boolean isCommand(String line) {
			return false;
		}

		@Override
		public void execute(String line, CommandContext context) {

		}

	};

	@Test
	public void testPostCommandSplit() {
		Tokenized tokenized = fixture
				.tokenize("Charlie -> I'm in New York today! Anyone want to have a coffee?");
		assertEquals("Charlie", tokenized.getFirstToken());
		assertEquals("->", tokenized.getControlToken());
		assertEquals("I'm in New York today! Anyone want to have a coffee?", tokenized.getLine());
	}

	@Test
	public void testFollowCommandSplit() {
		Tokenized tokenized = fixture.tokenize("Charlie follows Alice");
		assertEquals("Charlie", tokenized.getFirstToken());
		assertEquals("follows", tokenized.getControlToken());
		assertEquals("Alice", tokenized.getLine());
	}

	@Test
	public void testSingleStringCommand() {
		Tokenized tokenized = fixture.tokenize("test");
		assertEquals("test", tokenized.getFirstToken());
		assertEquals("", tokenized.getControlToken());
		assertEquals("", tokenized.getLine());
	}

}
