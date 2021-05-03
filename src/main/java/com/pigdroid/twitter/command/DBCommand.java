package com.pigdroid.twitter.command;

public class DBCommand extends CommandSupport {

	public static final String COMMAND = ".d";

	@Override
	public boolean isCommand(String line) {
		return COMMAND.equals(line);
	}

	@Override
	public void execute(String line, CommandContext context) {
		context.getApplicationService().showAllObjects(context.getOut());
	}

}
