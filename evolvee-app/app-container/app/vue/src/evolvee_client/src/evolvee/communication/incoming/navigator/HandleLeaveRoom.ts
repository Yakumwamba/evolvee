import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleLeaveRoom implements IIncomingEvent {
    handle(request: ServerMessage): void {
        EvolveeEnvironment.getGame().unloadRoom();
    }
    
}