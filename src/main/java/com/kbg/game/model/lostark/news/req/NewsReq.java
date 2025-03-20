package com.kbg.game.model.lostark.news.req;

import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewsReq {

    private String searchText;
    private String type;
    @Max(value = 20, message = "new.req.size.invalid")
    private int size;

}
