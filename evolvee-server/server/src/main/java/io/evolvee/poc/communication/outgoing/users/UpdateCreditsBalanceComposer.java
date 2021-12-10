package io.evolvee.poc.communication.outgoing.users;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class UpdateCreditsBalanceComposer extends ServerMessage {
	public UpdateCreditsBalanceComposer(int amount) {
		super(ServerOpCodes.CREDITS_BALANCE);
		appendInt(amount);
	}
}
