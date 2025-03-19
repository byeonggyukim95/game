package com.kbg.game.model.lostark;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CharacterClassCriticalResp {

    private Integer criticalSynergyCount;
    private Integer criticalPoint;

}
