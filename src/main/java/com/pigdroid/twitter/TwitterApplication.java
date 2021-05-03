package com.pigdroid.twitter;

import java.util.ArrayList;
import java.util.List;

import com.pigdroid.twitter.command.CommandContext;
import com.pigdroid.twitter.command.CommandLineCommand;
import com.pigdroid.twitter.command.DBCommand;
import com.pigdroid.twitter.command.FollowCommand;
import com.pigdroid.twitter.command.HelpCommand;
import com.pigdroid.twitter.command.PostCommand;
import com.pigdroid.twitter.command.QuitCommand;
import com.pigdroid.twitter.command.ShowUserCommand;
import com.pigdroid.twitter.command.ShowWallCommand;
import com.pigdroid.twitter.service.ApplicationService;
import com.pigdroid.util.console.ConsoleReader;
import com.pigdroid.util.console.ConsoleWriter;

public class TwitterApplication implements CommandContext, Runnable {

	private boolean running = true;
	private final ConsoleReader in;
	private final ConsoleWriter out;

	private final List<CommandLineCommand> commands = new ArrayList<>();
	private final ApplicationService applicationService;

	public TwitterApplication(ConsoleReader in, ConsoleWriter out, ApplicationContext context) {
		this.in = in;
		this.out = out;
		this.applicationService = context.getApplicationService();
		initCommands();
	}

	private void initCommands() {
		CommandLineCommand help = new HelpCommand();
		help.execute(HelpCommand.COMMAND, this);
		this.commands.add(help);
		this.commands.add(new QuitCommand());
		this.commands.add(new DBCommand());
		this.commands.add(new FollowCommand());
		this.commands.add(new PostCommand());
		this.commands.add(new ShowUserCommand());
		this.commands.add(new ShowWallCommand());
	}

	private void doMainLoop() {
		while (this.running) {
			this.out.print("> ");
			String line = in.readLine();
			CommandLineCommand command = findCommand(line);
			if (command == null) {
				out.println("Unknown command");
			} else {
				command.execute(line, this);
			}
		}
	}

	private CommandLineCommand findCommand(String line) {
		return this.commands.stream().filter(each -> each.isCommand(line)).findFirst().orElse(null);
	}

	@Override
	public ConsoleWriter getOut() {
		return out;
	}

	@Override
	public void run() {
		doMainLoop();
	}

	@Override
	public void setRunning(boolean b) {
		this.running = b;
	}

	@Override
	public ApplicationService getApplicationService() {
		return this.applicationService;
	}

}
