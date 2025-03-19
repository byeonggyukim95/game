package com.kbg.game.model.lostark.auctions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class AuctionInfo {

    private long startPrice;
    private Long buyPrice;
    private long bidPrice;
    private String endDate;
    private int bidCount;
    private long bidStartPrice;
    private boolean isCompetitive;
    private int tradeAllowCount;
    private Integer upgradeLevel;

}
