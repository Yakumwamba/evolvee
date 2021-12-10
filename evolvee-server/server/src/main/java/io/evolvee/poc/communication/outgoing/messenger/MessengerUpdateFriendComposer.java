package io.evolvee.poc.communication.outgoing.messenger;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;
import io.evolvee.poc.core.users.User;

public class MessengerUpdateFriendComposer extends ServerMessage {
	public MessengerUpdateFriendComposer(User user) {
		super(ServerOpCodes.MESSENGER_UPDATE_FRIEND);
		appendInt(user.getId());
		appendString(user.getUsername());
		appendString(user.getLook());
		appendString(user.getMotto());
		appendBoolean(user.isConnected());
	}
}
