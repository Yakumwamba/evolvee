import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleInventoryItemRemove implements IIncomingEvent {
    handle(request: ServerMessage) {
        const itemId = request.popInt();
        EvolveeEnvironment.getGame().inventory.removeItem(itemId);
    }
}