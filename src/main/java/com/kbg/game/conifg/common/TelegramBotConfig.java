package com.kbg.game.conifg.common;

import com.kbg.game.model.TelegramBot;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
@ConfigurationProperties("spring.transfer.telegram-bot")
public class TelegramBotConfig {

    private String url;
    private String name;
    private String token;
    private String chatId;

    @Bean(name = "telegramBot")
    public TelegramBot telegramBot(){
        return new TelegramBot(url, name, token, chatId);
    }

}
