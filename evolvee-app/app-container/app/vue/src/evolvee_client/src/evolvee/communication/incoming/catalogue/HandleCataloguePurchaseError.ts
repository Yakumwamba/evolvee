import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleCataloguePurchaseError implements IIncomingEvent{
    handle(request: ServerMessage): void {
        const notEnoughCredits = request.popBoolean();
        if (notEnoughCredits) {
            EvolveeEnvironment.getGame().uiManager.onShowNotification('Not enough credits');
        }
    }
}