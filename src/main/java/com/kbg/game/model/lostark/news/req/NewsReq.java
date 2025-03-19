package com.kbg.game.model.lostark.news.req;

import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsReq {

    private String searchText;
    private String type;
    @Max(value = 20)
    private int size;

}
