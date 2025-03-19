package com.kbg.game.model.lostark;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CharacterClassCriticalReq {

    @NotBlank
    private String characterClass;
    private Integer classNode;
    private Integer skill;
    @NotBlank
    private String backAttackYn;
    private BigDecimal firstRing;
    private BigDecimal secondRing;
    @NotBlank
    private String elixirYn;
    private BigDecimal adrenaline;
    private Integer arkPassiveNode;

}
