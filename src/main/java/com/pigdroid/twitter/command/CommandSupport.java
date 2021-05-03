package com.pigdroid.twitter.command;

public abstract class CommandSupport implements CommandLineCommand {

	private static final Tokenized DEFAULT = new Tokenized("", "", "");

	protected static class Tokenized {
		private String firstToken;
		private String controlToken;
		private String line;

		public Tokenized(String firstToken, String controlToken, String line) {
			super();
			this.firstToken = firstToken;
			this.controlToken = controlToken;
			this.line = line;
		}

		public String getControlToken() {
			return controlToken;
		}

		public String getFirstToken() {
			return firstToken;
		}

		public String getLine() {
			return line;
		}

	}

	protected Tokenized tokenize(String line) {
		Tokenized ret;
		if (line != null) {
			String[] split = line.split(" ");
			if (split.length == 1) {
				ret = new Tokenized(split[0].trim(), "", "");
			} else if (split.length == 2) {
				ret = new Tokenized(split[0].trim(), split[1].trim(), "");
			} else {
				int split1Size = split[1].length();
				String tail = line.substring(line.indexOf(split[1]) + split1Size).trim();
				ret = new Tokenized(split[0].trim(), split[1].trim(), tail);
			}
		} else {
			ret = DEFAULT;
		}
		return ret;
	}

}
