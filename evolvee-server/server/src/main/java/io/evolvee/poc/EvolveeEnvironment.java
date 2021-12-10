package io.evolvee.poc;

import java.util.Scanner;

import io.evolvee.poc.core.Game;
import io.evolvee.poc.misc.configs.ConfigManager;
import io.evolvee.poc.misc.logging.LogLevel;
import io.evolvee.poc.misc.logging.Logging;

public class EvolveeEnvironment {
	private static final String VERSION = "1.0.0 alpha";
	private static ConfigManager configManager;
	private static Game game;

	public static ConfigManager getConfigManager() {
		return configManager;
	}

	public static Game getGame() {
		return game;
	}
	
	private static void printSplash() {
		System.out.println();
		System.out.println("|         |    |          o     ");
		System.out.println("|---.,---.|---.|---.,---. .,---.");
		System.out.println("|   ||   ||   ||   |,---| ||   |");
		System.out.println("`---'`---'`---'`---'`---^o``---'");
		System.out.println(VERSION);
		System.out.println("Copyright (c) 2019 - Relevance");
		System.out.println("Made by Relevance. Follow me on instagram @josednn");
		System.out.println();
	}
	
	private static void startCommandLoop() {
		Scanner scn = new Scanner(System.in);
		String command;
		while (true) {
			try {
				command = scn.nextLine();
				String[] commandArgs = command.split(" ");
				switch (commandArgs[0]) {
				case "exit":
				case "stop":
					Logging.getInstance().writeLine("Stopping server...", LogLevel.None, EvolveeEnvironment.class);
					game.getConnectionManager().dispose();
					scn.close();
					System.exit(0);
					return;

				case "cycle":
					game.onCycle();
					Logging.getInstance().writeLine("Cycle forced!", LogLevel.None, EvolveeEnvironment.class);
					break;

				case "loglevel":
					Logging.getInstance().setLogLevel(Logging.valueOfLogLevel(commandArgs[1]));
					configManager.setLogLevel(commandArgs[1]);
					Logging.getInstance().writeLine(
							"Log level set to: " + Logging.getInstance().getLogLevel().toString(), LogLevel.None,
							EvolveeEnvironment.class);
					break;

				default:
					Logging.getInstance().writeLine("Invalid command", LogLevel.None, EvolveeEnvironment.class);
					break;
				}
			} catch (Exception e) {
				Logging.getInstance().writeLine("Error with command: " + e.toString(), LogLevel.None,
						EvolveeEnvironment.class);
			}
		}
	}

	public static void main(String[] args) {
		printSplash();
		configManager = new ConfigManager();
		if (!configManager.initialize("config.txt")) {
			Logging.getInstance().writeLine("Config file created. Please restart the server.",
					LogLevel.None, EvolveeEnvironment.class);
			return;
		}
		
		Logging.getInstance().setLogLevel(Logging.valueOfLogLevel(configManager.getLogLevel()));

		try {
			game = new Game();
			game.initialize(Integer.parseInt(configManager.getPort()));
			Logging.getInstance().writeLine("The environment has initialized successfully. Ready for connections.",
					LogLevel.Verbose, EvolveeEnvironment.class);
			
			startCommandLoop();
		} catch (Exception e) {
			Logging.getInstance().logError("Error initializing server", e, EvolveeEnvironment.class);
		}
		
	}
}
