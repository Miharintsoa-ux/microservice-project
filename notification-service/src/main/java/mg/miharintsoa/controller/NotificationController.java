package mg.miharintsoa.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {


    // /app/sendNotification
    @MessageMapping("/sendNotification")
    @SendTo("/topic/notification")
    public String sendMessage(String message){
        return message;
    }
}
