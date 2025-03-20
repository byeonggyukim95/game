package com.kbg.game.service.lostark;

import com.kbg.game.model.lostark.req.CharacterClassCriticalReq;
import com.kbg.game.model.lostark.resp.CharacterClassCriticalResp;

import java.util.List;

public interface LostarkService {

    List<CharacterClassCriticalResp> getCriticalCalculator(String characterClass) throws Exception;

    void insertCharacterClassCritical(CharacterClassCriticalReq characterClassCriticalReq) throws Exception;

}
