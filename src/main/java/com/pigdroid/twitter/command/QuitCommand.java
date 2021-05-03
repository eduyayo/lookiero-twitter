package com.pigdroid.twitter.command;

import com.pigdroid.util.console.ConsoleWriter;

public class QuitCommand extends CommandSupport {

	private static final String COMMAND = ".q";

	@Override
	public boolean isCommand(String line) {
		return COMMAND.equals(line);
	}

	@Override
	public void execute(String line, CommandContext context) {
		ConsoleWriter out = context.getOut();
		out.print("");
		out.println("quitting...");
		out.print("");
		context.setRunning(false);
	}

}
