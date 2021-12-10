package io.evolvee.poc.core;

import java.time.Duration;
import java.time.Instant;

import io.evolvee.poc.EvolveeEnvironment;
import io.evolvee.poc.core.catalogue.Catalogue;
import io.evolvee.poc.core.gameclients.GameClientManager;
import io.evolvee.poc.core.items.BaseItemManager;
import io.evolvee.poc.core.navigator.Navigator;
import io.evolvee.poc.core.rooms.RoomManager;
import io.evolvee.poc.core.users.UserManager;
import io.evolvee.poc.database.Database;
import io.evolvee.poc.misc.SSLHelper;
import io.evolvee.poc.misc.logging.Logging;
import io.evolvee.poc.net.ConnectionManager;

public class Game {
	private ConnectionManager connectionManager;
	private GameClientManager gameClientManager;
	private UserManager userManager;
	private BaseItemManager itemManager;
	private Catalogue catalogue;
	private Navigator navigator;
	private RoomManager roomManager;
	private Database database;

	private final int DELTA_TIME = 500;
	
	public Game() throws Exception {
		this.database = new Database(10, 2, EvolveeEnvironment.getConfigManager().getMysqlHost(), Integer.parseInt(EvolveeEnvironment.getConfigManager().getMysqlPort()), EvolveeEnvironment.getConfigManager().getMysqlDatabase(), EvolveeEnvironment.getConfigManager().getMysqlUser(), EvolveeEnvironment.getConfigManager().getMysqlPass());
		this.gameClientManager = new GameClientManager();
		this.userManager = new UserManager();
		this.itemManager = new BaseItemManager();
		this.catalogue = new Catalogue();
		this.roomManager = new RoomManager();
		this.navigator = new Navigator();
	}

	public void initialize(int port) throws Exception {
		if (EvolveeEnvironment.getConfigManager().getSslEnabled().toLowerCase().equals("true")) {
			this.connectionManager = new ConnectionManager(port, this.gameClientManager, SSLHelper.loadSslContext());
		} else {
			this.connectionManager = new ConnectionManager(port, this.gameClientManager);
		}

		Thread roomThread = new Thread(new Runnable() {
			@Override
			public void run() {
				gameThread();
			}
		});
		roomThread.start();

		getItemManager().initialize();
		getRoomManager().initialize();
		getCatalogue().initialize();
	}

	private void gameThread() {
		Instant starts, ends;
		while (true) {
			try {
				starts = Instant.now();
				onCycle();
				ends = Instant.now();

				long sleepTime = DELTA_TIME - Duration.between(starts, ends).toMillis();
				if (sleepTime < 0) {
					sleepTime = 0;
				}

				Thread.sleep(sleepTime);

			} catch (Exception e) {
				Logging.getInstance().logError("Game thread error", e, this.getClass());
			}
		}
	}

	public void onCycle() {
		this.roomManager.onCycle();
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public GameClientManager getGameClientManager() {
		return gameClientManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public BaseItemManager getItemManager() {
		return itemManager;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}
	
	public Database getDatabase() {
		return database;
	}
}
