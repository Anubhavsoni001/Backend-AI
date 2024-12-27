package com.backend.ai.service;


import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatService {

    @Autowired
    private ChatModel chatModel;
 // use of ai
    public String generateRisponse(String inputText) {
        String response =chatModel.call( inputText);
        return response;
    }
//use of ai
    public Flux<String> streamResponse(String inputText) {
        Flux<String> response =chatModel.stream( inputText);
        return response;
    }
}
