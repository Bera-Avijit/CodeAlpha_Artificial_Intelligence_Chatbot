package com.avijit.AI_ChatBot.Repository;

import com.avijit.AI_ChatBot.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatSessionId(String chatSessionId);
}
