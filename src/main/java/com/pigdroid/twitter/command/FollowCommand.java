package com.pigdroid.twitter.command;

import com.pigdroid.twitter.service.ApplicationService;

public class FollowCommand extends CommandSupport {

	public static final String COMMAND = "follows";

	@Override
	public boolean isCommand(String line) {
		return isFollow(tokenize(line));
	}

	private boolean isFollow(Tokenized tokenize) {
		return COMMAND.equalsIgnoreCase(tokenize.getControlToken());
	}

	@Override
	public void execute(String line, CommandContext context) {
		Tokenized tokenize = tokenize(line);
		if (isFollow(tokenize)) {
			ApplicationService service = context.getApplicationService();
			service.addUserFollow(tokenize.getFirstToken(), tokenize.getLine());
		}
	}

}
