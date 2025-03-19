package com.kbg.game.model.lostark.auctions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class AuctionItem {

    private int pageNo;
    private int pageSize;
    private long totalCount;
    private List<Item> items;

}
