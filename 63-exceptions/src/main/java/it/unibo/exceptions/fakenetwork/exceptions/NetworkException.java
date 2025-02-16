package it.unibo.exceptions.fakenetwork.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{
    
    private static final long serialVersionUID = 1L;
    
    public NetworkException(String message) {
        super("Network error while sending message: " + message);
    }

    public NetworkException() {
        super("Network error: no response");
    }
    
}
