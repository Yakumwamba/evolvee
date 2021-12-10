import EvolveeEnvironment from "../EvolveeEnvironment";
import RequestNavigatorSearchRooms from "../communication/outgoing/navigator/RequestNavigatorSearchRooms";
import RequestNavigatorPopularRooms from "../communication/outgoing/navigator/RequestNavigatorPopularRooms";
import RequestNavigatorOwnRooms from "../communication/outgoing/navigator/RequestNavigatorOwnRooms";
import RequestNavigatorLeaveRoom from "../communication/outgoing/navigator/RequestNavigatorLeaveRoom";
import RequestNavigatorGoToRoom from "../communication/outgoing/navigator/RequestNavigatorGoToRoom";
import RoomData from "./RoomData";
import RequestNavigatorCreateRoom from "../communication/outgoing/navigator/RequestNavigatorCreateRoom";

export default class Nav {
    requestSearchRooms(search: string) {
        EvolveeEnvironment.getGame().communicationManager.sendMessage(new RequestNavigatorSearchRooms(search));
    }

    requestPopularRooms() {
        EvolveeEnvironment.getGame().communicationManager.sendMessage(new RequestNavigatorPopularRooms());
    }

    requestOwnRooms() {
        EvolveeEnvironment.getGame().communicationManager.sendMessage(new RequestNavigatorOwnRooms());
    }

    requestGoToRoom(roomId: number) {
        EvolveeEnvironment.getGame().communicationManager.sendMessage(new RequestNavigatorGoToRoom(roomId));
    }

    requestLeaveRoom() {
        EvolveeEnvironment.getGame().communicationManager.sendMessage(new RequestNavigatorLeaveRoom());
    }

    handleRoomDataList(data: RoomData[]) {
        EvolveeEnvironment.getGame().uiManager.onLoadRoomList(data);
    }

    handleCurrentRoomData(data: RoomData) {
        EvolveeEnvironment.getGame().uiManager.onCurrentRoomDataLoad(data);
    }

    requestCreateRoom(roomName: string, modelId: string) {
        EvolveeEnvironment.getGame().communicationManager.sendMessage(new RequestNavigatorCreateRoom(roomName, modelId));
    }
}