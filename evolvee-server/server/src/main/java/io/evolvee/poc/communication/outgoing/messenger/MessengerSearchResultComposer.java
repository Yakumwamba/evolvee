package io.evolvee.poc.communication.outgoing.messenger;

import java.util.List;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;
import io.evolvee.poc.core.users.User;

public class MessengerSearchResultComposer extends ServerMessage {
	public MessengerSearchResultComposer(List<User> friends) {
		super(ServerOpCodes.MESSENGER_SEARCH_RESULT);
		appendInt(friends.size());
		for (User user: friends) {
			appendInt(user.getId());
			appendString(user.getUsername());
			appendString(user.getLook());
			appendString(user.getMotto());
			appendBoolean(true); // Is online?
		}
	}
}
