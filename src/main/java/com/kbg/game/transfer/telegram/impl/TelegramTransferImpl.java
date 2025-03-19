package com.kbg.game.transfer.telegram.impl;

import com.kbg.game.model.TelegramBot;
import com.kbg.game.transfer.telegram.TelegramTransfer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TelegramTransferImpl implements TelegramTransfer {

    private WebClient webClient;
    private TelegramBot telegramBot;

    private static final Integer TELEGRAM_MAX_MESSAGE = 4000;

    @Autowired
    public TelegramTransferImpl(TelegramBot telegramBot
            , WebClient.Builder builder) {
        this.telegramBot = telegramBot;
        this.webClient = builder.baseUrl(new StringBuilder(telegramBot.getUrl())
                .append(telegramBot.getToken()).toString()
        ).build();
    }

    public void sendMessage(String message) {
        Map<String, String> body = new HashMap<>();
        body.put("chat_id", telegramBot.getChatId());
        body.put("text", message.length() > TELEGRAM_MAX_MESSAGE ? message.substring(0, TELEGRAM_MAX_MESSAGE) : message);

        webClient.post().uri("/sendMessage")
                .bodyValue(body)
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }

}
