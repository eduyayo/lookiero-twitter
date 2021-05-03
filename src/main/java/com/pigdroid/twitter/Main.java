package com.pigdroid.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.pigdroid.util.console.ConsoleReader;
import com.pigdroid.util.console.ConsoleWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in))) {
			TwitterApplication app = new TwitterApplication(new ConsoleReader() {

				@Override
				public String readLine() {
					try {
						return buffer.readLine();
					} catch (IOException e) {
						//silently swallows
					}
					return ".q";
				}

			}, new ConsoleWriter() {

				@Override
				public void println(Object out) {
					System.out.println(out);
				}

				@Override
				public void print(Object out) {
					System.out.print(out);
				}
			}, new ApplicationContextImpl());
			app.run();
		}

	}

}
