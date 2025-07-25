package com.avijit.AI_ChatBot.Service;

import com.avijit.AI_ChatBot.Entity.ChatMessage;
import com.avijit.AI_ChatBot.Repository.ChatRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    // Access to API Key and URL (GEMINI)
    @Value("${gemini.api.url}")
    private String apiUrl;
    @Value("${gemini.api.key}")
    private String apiKey;

    private final WebClient.Builder webClientBuilder;
    private final ChatRepository chatRepository;

    public String getAnswer(String question, String chatSessionId) {
        WebClient webClient = webClientBuilder.build();

        // Save user message
        chatRepository.save(
                ChatMessage.builder()
                        .chatSessionId(chatSessionId)
                        .sender("USER")
                        .message(question)
                        .timestamp(LocalDateTime.now())
                        .build()
        );

        // Construct the request payload
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                        Map.of("text", question)
                                }
                        )
                }
        );

        // Make the API call
        String response = webClient.post()
                .uri(apiUrl + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String aiText = "No response from AI"; // default fallback text

        try {
            // Parse the response JSON and extract the AI's text response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response);
            aiText = root.path("candidates").get(0)
                    .path("content").path("parts").get(0).path("text").asText();
        }
        catch (Exception e) {
            e.printStackTrace();
            aiText = "Error extracting AI response";
        }

        // Save AI response
        chatRepository.save(
                ChatMessage.builder()
                        .chatSessionId(chatSessionId)
                        .sender("AI")
                        .message(aiText)
                        .timestamp(LocalDateTime.now())
                        .build()
        );

        // Return response
        return aiText;
    }

    public List<ChatMessage> getChatHistory(String chatSessionId) {
        // Retrieve chat history for the given session ID
        return chatRepository.findByChatSessionId(chatSessionId);
    }
}
