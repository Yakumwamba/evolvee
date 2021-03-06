import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";
import User from "../../../users/User";

export default class HandleMessengerRequests implements IIncomingEvent {
    handle(request: ServerMessage) {
        const count = request.popInt();
        const users: User[] = [];

        for (let i = 0; i < count; i++) {
            const id = request.popInt();
            const username = request.popString();
            const look = request.popString();
            const motto = request.popString();
            request.popBoolean();

            const user = EvolveeEnvironment.getGame().userManager.setUser(id, username, motto, look);
            users.push(user);
        }

        EvolveeEnvironment.getGame().messenger.handleFriendRequests(users);
    }
}