package com.pigdroid.twitter.command;

import com.pigdroid.twitter.service.ApplicationService;
import com.pigdroid.util.console.ConsoleWriter;

public interface CommandContext {

	ConsoleWriter getOut();

	void setRunning(boolean b);

	ApplicationService getApplicationService();

}
