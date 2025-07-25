package com.avijit.AI_ChatBot.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "chats")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String chatSessionId;

    private String sender;  // USER or AI

    @Column(columnDefinition = "TEXT")
    private String message;

    private LocalDateTime timestamp;

}
