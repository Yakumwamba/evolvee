package io.evolvee.poc.core.gameclients;

import io.evolvee.poc.EvolveeEnvironment;
import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.core.users.User;
import io.evolvee.poc.misc.logging.LogLevel;
import io.evolvee.poc.misc.logging.Logging;
import io.evolvee.poc.net.ClientConnection;

public class GameClient {
    private ClientConnection connection;
    private User user;

    public GameClient(int id, ClientConnection connection) {
        this.connection = connection;
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void handleMessage(String rawMessage) {
        Logging.getInstance().writeLine("Received: '" + rawMessage + "'", LogLevel.SuperDebug, this.getClass());
        ClientMessage message = new ClientMessage(rawMessage);
        EvolveeEnvironment.getGame().getGameClientManager().getSharedMessageHandler().handleMessage(this, message);
    }

    public void stop() {

        if (user != null) {
            user.onDisconnect();
        }
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }

    public void sendMessage(ServerMessage message) {
        Logging.getInstance().writeLine("Sent: '" + message.toString() + "'", LogLevel.SuperDebug, this.getClass());
        Logging.getInstance().writeLine("Composed by: " + message.getClass().getSimpleName(), LogLevel.Debug, this.getClass());
        if (this.connection != null && this.connection.isOpen()) {
            this.connection.send(message.toString());
        } else {
            stop();
        }
    }

}
