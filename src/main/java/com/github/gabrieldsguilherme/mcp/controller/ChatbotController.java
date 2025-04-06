package com.github.gabrieldsguilherme.mcp.controller;

import com.github.gabrieldsguilherme.mcp.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatbot/v1")
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotService chatbotService;

    @PostMapping("/chat")
    ResponseEntity<ChatResponse> chat(@RequestBody ChatRequest chatRequest) {
        String answer = chatbotService.chat(chatRequest.question());
        return ResponseEntity.ok(new ChatResponse(answer));
    }

    record ChatRequest(String question) {}

    record ChatResponse(String answer) {}

}
