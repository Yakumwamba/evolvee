import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleRoomItemRemove implements IIncomingEvent {
    handle(request: ServerMessage) {
        const itemId = request.popInt();
        const room = EvolveeEnvironment.getGame().currentRoom;
        if (room != null) {
            room.roomItemManager.removeItemFromRoom(itemId, true);
        }
    }
}