package com.bt.beertinder.controller;

import com.bt.beertinder.model.ChatHistory;
import com.bt.beertinder.model.ChatMessage;
import com.bt.beertinder.repository.ChatHistoryRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    private final ChatHistoryRepository chatHistoryRepository;

    // Konstruktor dla wstrzykiwania zależności
    public ChatController(ChatHistoryRepository chatHistoryRepository) {
        this.chatHistoryRepository = chatHistoryRepository;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        // Zapisujemy wiadomość w historii czatu
        ChatHistory chatHistory = new ChatHistory();
        chatHistory.setSender(chatMessage.getSender());
        chatHistory.setReceiver(chatMessage.getReceiver());
        chatHistory.setContent(chatMessage.getContent());
        chatHistory.setTimestamp(LocalDateTime.now());

        chatHistoryRepository.save(chatHistory); // Wywołanie metody na obiekcie repozytorium

        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage chatMessage) {
        chatMessage.setType(ChatMessage.MessageType.JOIN);
        return chatMessage;
    }
}
