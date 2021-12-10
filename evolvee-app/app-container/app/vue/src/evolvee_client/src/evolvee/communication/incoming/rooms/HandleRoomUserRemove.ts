import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleRoomUserRemove implements IIncomingEvent {
    handle(request: ServerMessage) {
        const userId = request.popInt();
        const room = EvolveeEnvironment.getGame().currentRoom;
        if (room != null) {
            room.roomUserManager.removeUserFromRoom(userId, true);
        }
    }
}