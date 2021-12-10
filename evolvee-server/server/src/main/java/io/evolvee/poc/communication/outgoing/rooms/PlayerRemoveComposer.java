package io.evolvee.poc.communication.outgoing.rooms;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class PlayerRemoveComposer extends ServerMessage {
    public PlayerRemoveComposer(int userId) {
        super(ServerOpCodes.PLAYER_REMOVE);
        appendInt(userId);
    }
}
