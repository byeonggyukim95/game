package com.kbg.game.model.lostark.req;

import com.kbg.game.common.annotation.EnumCodePattern;
import com.kbg.game.common.enums.CharacterClassCode;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CharacterClassCriticalReq {

    @EnumCodePattern(enumClass = CharacterClassCode.class, message = "characterClassCritical_req_invalid_characterClass")
    private String characterClass;
    private Integer classNode;
    private Integer skill;
    @NotBlank(message = "characterClassCritical_req_empty_backAttackYn")
    private String backAttackYn;
    private BigDecimal firstRing;
    private BigDecimal secondRing;
    @NotBlank(message = "characterClassCritical_req_empty_elixirYn")
    private String elixirYn;
    private BigDecimal adrenaline;
    private Integer arkPassiveNode;

}
