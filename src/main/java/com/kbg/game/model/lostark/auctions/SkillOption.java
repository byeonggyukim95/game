package com.kbg.game.model.lostark.auctions;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class SkillOption {

    private Integer firstOption;
    private Integer secondOption;
    private Integer minValue;
    private Integer maxValue;

}
