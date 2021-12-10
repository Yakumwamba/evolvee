package io.evolvee.poc.communication.outgoing.navigator;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class NavigatorLeaveRoomComposer extends ServerMessage {
	public NavigatorLeaveRoomComposer() {
		super(ServerOpCodes.NAVIGATOR_LEAVE_ROOM);
	}
}
