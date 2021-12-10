package io.evolvee.poc.communication.outgoing.rooms;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class FurniStateComposer extends ServerMessage {
    public FurniStateComposer(int furniId, int state) {
        super(ServerOpCodes.ITEM_STATE);
        appendInt(furniId);
        appendInt(state);
    }
}
