package com.pigdroid.twitter.command;

import com.pigdroid.twitter.service.ApplicationService;
import com.pigdroid.util.StringUtils;

public class ShowUserCommand extends CommandSupport {

	@Override
	public boolean isCommand(String line) {
		return isUser(tokenize(line));
	}

	private boolean isUser(Tokenized tokenize) {
		boolean ret = false;
		if (StringUtils.isEmpty(tokenize.getControlToken())
			&& StringUtils.isEmpty(tokenize.getLine())
			&& StringUtils.isNotEmpty(tokenize.getFirstToken())) {
			ret = true;
		}
		return ret;
	}

	@Override
	public void execute(String line, CommandContext context) {
		Tokenized tokenize = tokenize(line);
		if (isUser(tokenize)) {
			ApplicationService service = context.getApplicationService();
			service.showUserMessages(tokenize.getFirstToken(), context.getOut());
		}
	}

}
