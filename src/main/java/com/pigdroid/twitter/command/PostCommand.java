package com.pigdroid.twitter.command;

import com.pigdroid.twitter.service.ApplicationService;

public class PostCommand extends CommandSupport {

	public static final String COMMAND = "->";

	@Override
	public boolean isCommand(String line) {
		return isPost(tokenize(line));
	}

	private boolean isPost(Tokenized tokenize) {
		return COMMAND.equals(tokenize.getControlToken());
	}

	@Override
	public void execute(String line, CommandContext context) {
		Tokenized tokenize = tokenize(line);
		if (isPost(tokenize)) {
			ApplicationService service = context.getApplicationService();
			service.postMessage(tokenize.getFirstToken(), tokenize.getLine());
		}
	}

}
