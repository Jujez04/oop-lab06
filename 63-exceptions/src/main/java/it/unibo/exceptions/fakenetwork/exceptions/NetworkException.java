package it.unibo.exceptions.fakenetwork.exceptions;

import java.io.IOException;

public class NetworkException extends IOException{
    
    public NetworkException(String message) {
        System.out.println("Network error while sending message: " + message);
    }

    public NetworkException() {
        System.out.println("Network error: no response");
    }
    
}
