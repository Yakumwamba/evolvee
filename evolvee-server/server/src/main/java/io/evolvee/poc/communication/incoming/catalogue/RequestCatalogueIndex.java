package io.evolvee.poc.communication.incoming.catalogue;

import io.evolvee.poc.EvolveeEnvironment;
import io.evolvee.poc.communication.incoming.IIncomingEvent;
import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.core.gameclients.GameClient;
import io.evolvee.poc.core.users.User;

public class RequestCatalogueIndex implements IIncomingEvent {

    @Override
    public void handle(GameClient client, ClientMessage request) {
    	User user = client.getUser();
        if (user != null){
        	EvolveeEnvironment.getGame().getCatalogue().serializeIndex(user);
        }
    }
}
