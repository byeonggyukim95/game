package com.kbg.game.conifg.mapper.game;

import com.kbg.game.model.lostark.CharacterClassCritical;
import com.kbg.game.model.lostark.CharacterClassCriticalReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GameMapper {

    CharacterClassCritical selectCharacterClassCritical(@Param("characterClass") String characterClass) throws Exception;

    void insertCharacterClassCritical(CharacterClassCriticalReq characterClassCriticalReq) throws Exception;

}
