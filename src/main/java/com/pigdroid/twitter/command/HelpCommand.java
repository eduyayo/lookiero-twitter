package com.pigdroid.twitter.command;

import com.pigdroid.util.console.ConsoleWriter;

public class HelpCommand extends CommandSupport {

	public static final String COMMAND = ".h";

	@Override
	public boolean isCommand(String line) {
		return COMMAND.equals(line);
	}

	@Override
	public void execute(String line, CommandContext context) {
		ConsoleWriter out = context.getOut();
		out.print("");
		out.println(".h: for help");
		out.println(".q: quits the program");
		out.println(".d prints db contents");
		out.println("username: lists the messages from a user");
		out.println("username wall: shows user wall");
		out.println("username follows otherusername: add user relation");
		out.print("");
	}

}
