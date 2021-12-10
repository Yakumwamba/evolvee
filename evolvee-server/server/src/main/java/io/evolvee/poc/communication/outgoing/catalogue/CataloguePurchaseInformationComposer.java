package io.evolvee.poc.communication.outgoing.catalogue;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;
import io.evolvee.poc.core.catalogue.CatalogueItem;
import io.evolvee.poc.core.items.ItemType;

public class CataloguePurchaseInformationComposer extends ServerMessage {

	public CataloguePurchaseInformationComposer(CatalogueItem item) {
		super(ServerOpCodes.CATALOGUE_PURCHASE_INFO);
		appendInt(item.getId());
		appendString(item.getBaseItem().getItemName());
		appendInt(item.getCost());
		appendString(item.getBaseItem().getType() == ItemType.RoomItem ? "F" : "W");
		appendInt(item.getBaseItem().getBaseId());
	}

}
