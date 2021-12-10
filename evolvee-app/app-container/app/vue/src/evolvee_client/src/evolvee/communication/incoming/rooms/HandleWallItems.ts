import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";
import { Direction } from "../../../imagers/furniture/FurniImager";

export default class HandleWallItems implements IIncomingEvent {
    handle(request: ServerMessage) {
        const count = request.popInt();
        for (let i = 0; i < count; i++) {

            const id = request.popInt();
            const x = request.popInt();
            const y  = request.popInt();
            const rot = request.popInt();
            const baseId = request.popInt();
            const state = request.popInt();

            const room = EvolveeEnvironment.getGame().currentRoom;
            if (room != null) {
                room.roomItemManager.addWallItemToRoom(id, x, y, rot as Direction, state, baseId);
            }
        }
    }
}