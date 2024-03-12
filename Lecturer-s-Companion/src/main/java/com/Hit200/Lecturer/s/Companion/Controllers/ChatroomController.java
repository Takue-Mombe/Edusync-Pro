package com.Hit200.Lecturer.s.Companion.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller

public class ChatroomController {


        @Autowired
        private SimpMessagingTemplate simpMessagingTemplate;

        @MessageMapping("/message")
        @SendTo("/chatroom/public")
        public Message receiverPublicMessage(@Payload Message message){
            return message;
        }

        @MessageMapping("/private-message")
        public Message receivePrivateMessage(@Payload Message message){

            //need to fix this
            simpMessagingTemplate.convertAndSendToUser(message.toString(),"/private",message);
            return message;
        }
    }
