package io.evolvee.poc.communication.outgoing.rooms;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;
import io.evolvee.poc.core.rooms.items.WallItem;

import java.util.Arrays;
import java.util.List;

public class SerializeWallItemComposer  extends ServerMessage {
    public SerializeWallItemComposer(List<WallItem> items) {
        super(ServerOpCodes.WALL_ITEM_DATA);
        appendInt(items.size());
        for (WallItem item : items) {
            appendInt(item.getId());
            appendInt(item.getX());
            appendInt(item.getY());
            appendInt(item.getRot());
            appendInt(item.getBaseItem().getBaseId());
            appendInt(item.getState());
        }
    }
    public SerializeWallItemComposer(WallItem item) {
        this(Arrays.asList(item));
    }
}
