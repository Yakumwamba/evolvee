package io.evolvee.poc.communication.outgoing.rooms;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class ChatComposer extends ServerMessage {
	public ChatComposer(int userId, String chat) {
		super(ServerOpCodes.CHAT);
		appendInt(userId);
		appendString(chat);
	}
}
