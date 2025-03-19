package com.kbg.game.conifg.common;

import com.kbg.game.model.LostarkApi;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
@ConfigurationProperties("spring.transfer.lostark")
public class LostarkApiConfig {

    private String url;
    private String apiKey;

    @Bean(name = "lostarkApi")
    public LostarkApi lostarkApi(){
        return new LostarkApi(url, apiKey);
    }

}
