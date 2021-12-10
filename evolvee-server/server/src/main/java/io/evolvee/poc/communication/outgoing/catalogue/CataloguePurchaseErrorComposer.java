package io.evolvee.poc.communication.outgoing.catalogue;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class CataloguePurchaseErrorComposer extends ServerMessage {
	public CataloguePurchaseErrorComposer() {
		super(ServerOpCodes.CATALOGUE_PURCHASE_ERROR);
		appendBoolean(true);
	}
}