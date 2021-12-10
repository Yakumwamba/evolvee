import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleIncomingChat implements IIncomingEvent {
    handle(request: ServerMessage) {
        const userId = request.popInt();
        const text = request.popString();

        const room = EvolveeEnvironment.getGame().currentRoom;
        if (room != null) {
            room.chatManager.addChat(userId, text);
        }
    }
}