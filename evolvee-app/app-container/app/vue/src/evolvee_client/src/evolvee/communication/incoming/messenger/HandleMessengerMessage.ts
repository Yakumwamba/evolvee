import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";
import { MessengerMessageType } from "../../../messenger/Messenger";

export default class HandleMessengerMessage implements IIncomingEvent {
    handle(request: ServerMessage) {
        const userId = request.popInt();
        const text = request.popString();
        const isMe = request.popBoolean();

        EvolveeEnvironment.getGame().messenger.handleMessengerMessage(userId, text, isMe ? MessengerMessageType.Me : MessengerMessageType.Friend);
    }
}