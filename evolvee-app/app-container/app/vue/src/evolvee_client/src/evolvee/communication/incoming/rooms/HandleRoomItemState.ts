import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleRoomItemState implements IIncomingEvent {
    handle(request: ServerMessage) {
        const itemId = request.popInt();
        const state = request.popInt();
        const room = EvolveeEnvironment.getGame().currentRoom;
        if (room != null) {
            room.roomItemManager.itemSetState(itemId, state);
        }
    }
}