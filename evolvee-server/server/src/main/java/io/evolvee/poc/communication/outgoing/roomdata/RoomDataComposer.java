package io.evolvee.poc.communication.outgoing.roomdata;

import io.evolvee.poc.communication.outgoing.navigator.NavigatorRoomListComposer;
import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;
import io.evolvee.poc.core.rooms.roomdata.RoomData;

public class RoomDataComposer extends ServerMessage {
	public RoomDataComposer(RoomData roomData) {
		super(ServerOpCodes.ROOM_DATA);
		NavigatorRoomListComposer.serializeRoomData(roomData, this);
	}
}
