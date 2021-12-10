package io.evolvee.poc.communication.outgoing.users;

import io.evolvee.poc.communication.protocol.ServerMessage;
import io.evolvee.poc.communication.protocol.ServerOpCodes;

public class LoginOkComposer extends ServerMessage {
    public LoginOkComposer(int id, String name, String look, String motto) {
        super(ServerOpCodes.LOGIN_OK);
        
        appendInt(id);
        appendString(name);
        appendString(look);
        appendString(motto);
    }
}
