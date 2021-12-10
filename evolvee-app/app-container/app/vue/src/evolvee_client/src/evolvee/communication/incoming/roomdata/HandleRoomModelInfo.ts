import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleRoomModelInfo implements IIncomingEvent {
    handle(request: ServerMessage) {
        const modelId = request.popString();
        const roomId = request.popInt();

        EvolveeEnvironment.getGame().handleRoomModelInfo(modelId, roomId);
    }
}