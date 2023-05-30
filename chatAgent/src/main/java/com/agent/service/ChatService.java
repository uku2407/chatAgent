package com.agent.service;

import com.agent.api.ChatGPTClient;
import com.agent.model.ChatMessage;
@SuppressWarnings("unused")
public class ChatService {
    private com.agent.api.ChatGPTClient ChatGPTClient;

    public ChatService() {
        // Initialize the ChatGPTClient
        ChatGPTClient = new com.agent.api.ChatGPTClient();
    }



    public ChatMessage sendChatMessage(ChatMessage chatMessage) {
        // Make API call to ChatGPT server
        String response = ChatGPTClient.sendMessage(chatMessage.getInput());

        // Process the API response and update the chatMessage object
        chatMessage.setOutput(response);

        return chatMessage;
    }
}
