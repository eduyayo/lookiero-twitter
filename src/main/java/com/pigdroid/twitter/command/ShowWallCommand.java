package com.pigdroid.twitter.command;

import com.pigdroid.twitter.service.ApplicationService;
import com.pigdroid.util.StringUtils;

public class ShowWallCommand extends CommandSupport {

	@Override
	public boolean isCommand(String line) {
		return isWall(tokenize(line));
	}

	private boolean isWall(Tokenized tokenize) {
		return StringUtils.isEmpty(tokenize.getLine())
				&& StringUtils.isNotEmpty(tokenize.getFirstToken())
				&& "wall".equalsIgnoreCase(tokenize.getControlToken());
	}

	@Override
	public void execute(String line, CommandContext context) {
		Tokenized tokenize = tokenize(line);
		if (isWall(tokenize)) {
			ApplicationService service = context.getApplicationService();
			service.showUserWall(tokenize.getFirstToken(), context.getOut());
		}
	}

}
