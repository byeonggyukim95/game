package com.kbg.game.common.enums;

import lombok.Getter;

@Getter
public enum CharacterClassCode {

    LUNAR_VOICE("LUNAR_VOICE", "달의소리"),
    PREDATOR("predator", "포식자"),
    FULL_MOON_HARVESTER("FULL_MOON_HARVESTER", "만월"),
    ;

    private String code;
    private String name;

    CharacterClassCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
