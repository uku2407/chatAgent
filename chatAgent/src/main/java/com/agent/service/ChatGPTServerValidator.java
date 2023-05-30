package com.agent.service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ChatGPTServerValidator {
    private static final String PING_URL = "https://rest.ensembl.org";
    private OkHttpClient httpClient;

    public ChatGPTServerValidator() {
        // Initialize the OkHttpClient
        httpClient = new OkHttpClient();
    }

    public boolean isServerAvailable() {
        try {
            Request request = new Request.Builder()
                    .url(PING_URL)
                    .build();

            Response response = httpClient.newCall(request).execute();

            return response.isSuccessful();
        } catch (IOException e) {
            // Handle network or API call error
            return false;
        }
    }

    public static void main(String[] args) {
        ChatGPTServerValidator validator = new ChatGPTServerValidator();
        boolean isAvailable = validator.isServerAvailable();

        if (isAvailable) {
            System.out.println("ChatGPT server is available.");
        } else {
            System.out.println("ChatGPT server is not available.");
        }
    }
}
