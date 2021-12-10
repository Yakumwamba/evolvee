package io.evolvee.poc.communication.outgoing.catalogue;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;
import io.evolvee.poc.core.catalogue.CatalogueItem;
import io.evolvee.poc.core.catalogue.CataloguePage;
import io.evolvee.poc.core.items.ItemType;

public class CataloguePageComposer extends ServerMessage {
	public CataloguePageComposer(CataloguePage page) {
		super(ServerOpCodes.CATALOGUE_PAGE);
		appendInt(page.getId());
		appendString(page.getLayout());
		appendString(page.getImageHeadline());
		appendString(page.getImageTeaser());
		appendString(page.getTextHeader());
		appendString(page.getTextDetails());
		appendString(page.getTextMisc());
		appendString(page.getTextMisc2());
		
		appendInt(page.getItems().size());
		for (CatalogueItem item: page.getItems()) {
			appendInt(item.getId());
			appendString(item.getName());
			appendInt(item.getCost());
			appendString(item.getBaseItem().getType() == ItemType.RoomItem ? "F" : "W");
			appendInt(item.getBaseItem().getBaseId());
			appendInt(item.getAmount());
		}
	}
	
}
