import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class LoginOk implements IIncomingEvent {
    handle(request: ServerMessage) {

        const id = request.popInt();
        const name = request.popString();
        const look = request.popString();
        const motto = request.popString();
        EvolveeEnvironment.getGame().handleUserData(id, name, look, motto);
    }
}