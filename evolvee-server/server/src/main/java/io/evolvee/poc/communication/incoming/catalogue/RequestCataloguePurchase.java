package io.evolvee.poc.communication.incoming.catalogue;

import io.evolvee.poc.EvolveeEnvironment;
import io.evolvee.poc.communication.incoming.IIncomingEvent;
import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.core.gameclients.GameClient;
import io.evolvee.poc.core.users.User;

public class RequestCataloguePurchase implements IIncomingEvent {

    @Override
    public void handle(GameClient client, ClientMessage request) {
    	User user = client.getUser();
        if (user != null){
        	int pageId = request.popInt();
        	int itemId = request.popInt();
        	EvolveeEnvironment.getGame().getCatalogue().handlePurchase(user, pageId, itemId);
        }
    }
}
