package io.evolvee.poc.communication.outgoing.messenger;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class MessengerMessageComposer extends ServerMessage {
	public MessengerMessageComposer(int userId, String text, boolean isMe) {
		super(ServerOpCodes.MESSENGER_MESSAGE);
		appendInt(userId);
		appendString(text);
		appendBoolean(isMe);
	}
}
