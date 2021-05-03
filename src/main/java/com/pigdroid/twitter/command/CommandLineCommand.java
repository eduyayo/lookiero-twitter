package com.pigdroid.twitter.command;

public interface CommandLineCommand {

	boolean isCommand(String line);

	void execute(String line, CommandContext context);

}
