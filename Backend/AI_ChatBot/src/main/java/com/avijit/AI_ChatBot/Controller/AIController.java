package com.avijit.AI_ChatBot.Controller;

import com.avijit.AI_ChatBot.Entity.ChatMessage;
import com.avijit.AI_ChatBot.Service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AIController {

    private final AIService aiService;
    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody Map<String, String> payload){
        String question = payload.get("question");
        String sessionId = payload.get("chatSessionId");

        if (question == null || question.isBlank() || sessionId == null || sessionId.isBlank()) {
            return ResponseEntity.badRequest().body("Invalid request: Missing question or sessionId");
        }

        String answer = aiService.getAnswer(question, sessionId);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/chat/history/{sessionId}")
    public ResponseEntity<List<ChatMessage>> getChatHistoryBySession(@PathVariable String sessionId){
        List<ChatMessage> history = aiService.getChatHistory(sessionId);
        return ResponseEntity.ok(history);
    }

}
