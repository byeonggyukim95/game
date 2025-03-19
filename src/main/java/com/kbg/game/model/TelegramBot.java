package com.kbg.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TelegramBot {

    private String url;
    private String name;
    private String token;
    private String chatId;

    public TelegramBot(String url, String name, String token, String chatId) {
        this.url = url;
        this.name = name;
        this.token = token;
        this.chatId = chatId;
    }

}
