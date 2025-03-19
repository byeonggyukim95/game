package com.kbg.game.model.lostark.auctions.req;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kbg.game.model.lostark.auctions.EtcOption;
import com.kbg.game.model.lostark.auctions.SkillOption;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class AuctionsItemsReq {

    private int itemLevelMin;
    private int itemLevelMax;
    private Integer itemGradeQuality;
    private Integer itemUpgradeLevel;
    private Integer itemTradeAllowCount;
    private List<SkillOption> skillOptions;
    private List<EtcOption> etcOptions;
    // TODO : Enum(BIDSTART_PRICE, BUY_PRICE, EXPIREDATE, ITEM_GRADE, ITEM_LEVEL, ITEM_QUALITY)
    private String sort;
    private int categoryCode;
    private String characterClass;
    private Integer itemTier;
    private String itemGrade;
    private String itemName;
    private int pageNo;
    // TODO : Enum(ASC, DESC)
    private String sortCondition;

}
