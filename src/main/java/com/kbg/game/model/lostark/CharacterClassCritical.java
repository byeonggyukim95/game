package com.kbg.game.model.lostark;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CharacterClassCritical {

    private String characterClass;
    private Integer classNode;
    private Integer skill;
    private String backAttackYn;
    private BigDecimal firstRing;
    private BigDecimal secondRing;
    private String elixirYn;
    private BigDecimal adrenaline;
    private Integer arkPassiveNode;

}
