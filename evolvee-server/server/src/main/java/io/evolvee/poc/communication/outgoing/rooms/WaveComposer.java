package io.evolvee.poc.communication.outgoing.rooms;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class WaveComposer extends ServerMessage {
	public WaveComposer(int userId) {
		super(ServerOpCodes.PLAYER_WAVE);
		appendInt(userId);
	}
}
