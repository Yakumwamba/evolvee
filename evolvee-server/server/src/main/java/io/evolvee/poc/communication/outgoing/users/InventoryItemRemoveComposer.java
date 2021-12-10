package io.evolvee.poc.communication.outgoing.users;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class InventoryItemRemoveComposer extends ServerMessage {
    public InventoryItemRemoveComposer(int itemId) {
        super(ServerOpCodes.INVENTORY_ITEM_REMOVE);
        appendInt(itemId);
    }
}
