package io.evolvee.poc.core.rooms.items.interactors;

import io.evolvee.poc.core.rooms.users.RoomUser;
import io.evolvee.poc.core.rooms.items.RoomItem;

public abstract class RoomItemInteractor {
    private RoomItem item;
    public RoomItemInteractor(RoomItem item){
        this.item = item;
    }
    public RoomItem getItem() {
        return this.item;
    }
    public abstract void onTrigger(RoomUser roomUser, boolean userHasRights);
}
