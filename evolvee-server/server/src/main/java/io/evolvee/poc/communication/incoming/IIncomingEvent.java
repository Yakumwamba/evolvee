package io.evolvee.poc.communication.incoming;

import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.core.gameclients.GameClient;

public interface IIncomingEvent {
    void handle(GameClient client, ClientMessage request);
}
