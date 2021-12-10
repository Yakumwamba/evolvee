package io.evolvee.poc.core.rooms.items;

import io.evolvee.poc.core.items.BaseItem;
import io.evolvee.poc.core.rooms.Room;

public class WallItem extends RoomItem {
    public WallItem(int id, int x, int y, int rot, int state, Room room, BaseItem baseItem) {
        super(id, x, y, 0, rot, state, room, baseItem);
    }
}
