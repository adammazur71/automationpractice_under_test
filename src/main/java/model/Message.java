package model;

import enums.MessageSubject;
import lombok.Data;

@Data
public class Message {

    private MessageSubject messageSubject;
    private String email;
    private String orderReference;
    private String message;
}
