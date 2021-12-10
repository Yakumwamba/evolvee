import IIncomingEvent from "../IIncomingEvent";
import ServerMessage from "../../protocol/ServerMessage";
import EvolveeEnvironment from "../../../EvolveeEnvironment";

export default class HandleUpdateCreditsBalance implements IIncomingEvent{
    handle(request: ServerMessage): void {
        const credits = request.popInt();   
        EvolveeEnvironment.getGame().userManager.updateCreditsBalance(credits);
    }
}