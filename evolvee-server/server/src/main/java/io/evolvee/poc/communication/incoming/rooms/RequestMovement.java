package io.evolvee.poc.communication.incoming.rooms;

import io.evolvee.poc.communication.incoming.IIncomingEvent;
import io.evolvee.poc.communication.protocol.ClientMessage;
import io.evolvee.poc.core.gameclients.GameClient;
import io.evolvee.poc.core.rooms.users.RoomUser;

public class RequestMovement implements IIncomingEvent {
    @Override
    public void handle(GameClient client, ClientMessage request) {
        int x = request.popInt();
        int y = request.popInt();

        RoomUser user = client.getUser().getCurrentRoomUser();
        if (user != null) {
            user.moveTo(x, y);
        }
    }
}
