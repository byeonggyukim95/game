package com.kbg.game.model.lostark.auctions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class Option {

    // TODO : Enum(None, SKILL, STAT, ABILITY_ENGRAVE, BRACELET_SPECIAL_EFFECTS, GEM_SKILL_DAMAGE, GEM_SKILL_COOLDOWN_REDUCTION, GEM_SKILL_SUPPORT, ACCESSORY_UPGRADE, ARK_PASSIVE, BRACELET_RANDOM_SLOT)
    private String type;
    private String optionName;
    private String optionNameTripod;
    private double value;
    private boolean isPenalty;
    private String className;
    private boolean isValuePercentage;

}
