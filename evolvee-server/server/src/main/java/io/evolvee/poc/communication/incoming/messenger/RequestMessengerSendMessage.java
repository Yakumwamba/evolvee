package io.evolvee.poc.communication.incoming.messenger;

import io.evolvee.poc.communication.incoming.IIncomingEvent;
import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.core.gameclients.GameClient;
import io.evolvee.poc.core.users.User;

public class RequestMessengerSendMessage implements IIncomingEvent {
    @Override
    public void handle(GameClient client, ClientMessage request) {
    	User user = client.getUser();
        if (user != null){
        	int userId = request.popInt();
        	String text = request.popString();
        	
        	user.getMessenger().handleMessengerMessage(userId, text);
        }
    }
}