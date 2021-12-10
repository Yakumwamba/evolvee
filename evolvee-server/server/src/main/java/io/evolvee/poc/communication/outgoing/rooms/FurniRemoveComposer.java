package io.evolvee.poc.communication.outgoing.rooms;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class FurniRemoveComposer extends ServerMessage {
    public FurniRemoveComposer(int furniId)
    {
        super(ServerOpCodes.ITEM_REMOVE);
        appendInt(furniId);
    }
}
