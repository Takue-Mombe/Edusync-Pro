package com.Hit200.Lecturer.s.Companion.Services;

import com.Hit200.Lecturer.s.Companion.Models.Message;
import com.Hit200.Lecturer.s.Companion.Repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {


    @Autowired
    private MessageRepo messageRepo;

    public String saveMessage(Message message){
        messageRepo.save(message);
        return "Contained...";
    }
    public String deleteMessage(Long id){
        messageRepo.deleteById(id);
        return "deleted...";
    }
    public String getMessages(Message message){
        messageRepo.findAll();
        return null;
    }

}
