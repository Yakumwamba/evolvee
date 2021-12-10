import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import { getRoomData } from "../roomdata/HandleRoomData";
import RoomData from "../../../navigator/RoomData";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleRoomList implements IIncomingEvent {
    handle(request: ServerMessage): void {
        const count = request.popInt();
        const roomDatas: RoomData[] = [];
        for (let i = 0; i < count; i++) {
            const data = getRoomData(request);
            roomDatas.push(data);
        }

        EvolveeEnvironment.getGame().navigator.handleRoomDataList(roomDatas);
    }
}