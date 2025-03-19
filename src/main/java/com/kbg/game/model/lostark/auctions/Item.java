package com.kbg.game.model.lostark.auctions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Item {

    private String name;
    private String grade;
    private int tier;
    private Integer level;
    private String icon;
    private Integer gradeQuality;
    private AuctionInfo auctionInfo;
    private List<Option> options;

}
