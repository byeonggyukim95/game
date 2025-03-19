package com.kbg.game.service.lostark;

import com.kbg.game.model.lostark.CharacterClassCriticalReq;
import com.kbg.game.model.lostark.CharacterClassCriticalResp;

import java.util.List;

public interface LostarkService {

    List<CharacterClassCriticalResp> getCriticalCalculator(String characterClass) throws Exception;

    void insertCharacterClassCritical(CharacterClassCriticalReq characterClassCriticalReq) throws Exception;

}
