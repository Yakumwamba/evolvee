package io.evolvee.poc.communication.outgoing.roomdata;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class RoomModelInfoComposer  extends ServerMessage {
    public RoomModelInfoComposer(String modelId, int roomId) {
    	super(ServerOpCodes.ROOM_DATA_MODEL_INFO);
    	appendString(modelId);
    	appendInt(roomId);
    }
}
