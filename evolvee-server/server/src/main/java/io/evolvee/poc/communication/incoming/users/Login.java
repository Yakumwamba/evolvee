package io.evolvee.poc.communication.incoming.users;

import io.evolvee.poc.EvolveeEnvironment;
import io.evolvee.poc.communication.incoming.IIncomingEvent;
import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.core.gameclients.GameClient;

public class Login implements IIncomingEvent {

    @Override
    public void handle(GameClient client, ClientMessage request) {
        String username = request.popString();
        String look = request.popString();
        EvolveeEnvironment.getGame().getUserManager().tryLogin(client, username, look);
    }
}
