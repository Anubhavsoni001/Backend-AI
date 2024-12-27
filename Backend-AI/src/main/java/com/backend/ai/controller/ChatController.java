package com.backend.ai.controller;


import com.backend.ai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@Controller
@RequestMapping("/api/v1/chat")
public class ChatController {
@Autowired
    private ChatService chatService;



    @GetMapping
    public ResponseEntity<String> generateResponse(
            @RequestParam(value = "inputText") String  inputText) {
        String responseText =  chatService.generateRisponse(inputText);
        return ResponseEntity.ok(responseText);

    }



    @GetMapping("/stream")
    public Flux<String> streamResponse(
            @RequestParam(value = "inputText") String  inputText) {
           Flux<String> response =  chatService.streamResponse(inputText);

        return  response;

    }
}
