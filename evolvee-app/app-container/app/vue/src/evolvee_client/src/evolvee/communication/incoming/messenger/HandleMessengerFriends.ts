import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";
import User from "../../../users/User";

export default class HandleMessengerFriends implements IIncomingEvent {
    handle(request: ServerMessage) {
        const count = request.popInt();
        const onlineFriends: User[] = [];
        const offlineFriends: User[] = [];

        for (let i = 0; i < count; i++) {
            const id = request.popInt();
            const username = request.popString();
            const look = request.popString();
            const motto = request.popString();
            const isOnline = request.popBoolean();

            const user = EvolveeEnvironment.getGame().userManager.setUser(id, username, motto, look);
            if (isOnline) {
                onlineFriends.push(user);
            } else {
                offlineFriends.push(user);
            }
        }

        EvolveeEnvironment.getGame().messenger.handleFriends(onlineFriends, offlineFriends);
    }
}