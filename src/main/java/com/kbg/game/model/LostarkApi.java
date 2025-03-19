package com.kbg.game.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LostarkApi {

    private String url;
    private String apiKey;

    public LostarkApi(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }

}
