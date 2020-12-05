package com.mycompany.app;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private MessageTypes type;
    private String message;

    public Message(MessageTypes mt, String msg) {
        this.setType(mt);
        this.setMessage(msg);
    }
}

enum MessageTypes {
    WELCOME, MESSAGE, CLOSE
}