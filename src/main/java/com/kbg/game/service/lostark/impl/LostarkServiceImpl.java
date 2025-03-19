package com.kbg.game.service.lostark.impl;

import com.kbg.game.conifg.mapper.game.GameMapper;
import com.kbg.game.model.lostark.CharacterClassCritical;
import com.kbg.game.model.lostark.CharacterClassCriticalReq;
import com.kbg.game.model.lostark.CharacterClassCriticalResp;
import com.kbg.game.service.lostark.LostarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class LostarkServiceImpl implements LostarkService {

    private BigDecimal MAX_CRITICAL = BigDecimal.valueOf(119.28);

    private GameMapper gameMapper;

    @Autowired
    public LostarkServiceImpl(GameMapper gameMapper) {
        this.gameMapper = gameMapper;
    }

    @Override
    public List<CharacterClassCriticalResp> getCriticalCalculator(String characterClass) throws Exception {
        CharacterClassCritical characterClassCritical = gameMapper.selectCharacterClassCritical(characterClass);

        BigDecimal getCritical = characterClassCritical.getFirstRing()
                .add(characterClassCritical.getSecondRing())
                .add(characterClassCritical.getAdrenaline())
                .add(BigDecimal.valueOf(characterClassCritical.getClassNode() + characterClassCritical.getSkill() + characterClassCritical.getArkPassiveNode()))
                .add(characterClassCritical.getBackAttackYn().equalsIgnoreCase("Y") ? BigDecimal.TEN : BigDecimal.ZERO)
                .add(characterClassCritical.getElixirYn().equalsIgnoreCase("Y") ? BigDecimal.valueOf(7) : BigDecimal.ZERO);

        List<CharacterClassCriticalResp> characterClassCriticalRespList = new ArrayList<>();
        characterClassCriticalRespList.add(CharacterClassCriticalResp.builder()
                .criticalSynergyCount(1)
                .criticalPoint(MAX_CRITICAL.subtract(getCritical.add(BigDecimal.TEN))
                        .divide(BigDecimal.valueOf(0.03579), 0, RoundingMode.UP).
                        intValue())
                .build());

        characterClassCriticalRespList.add(CharacterClassCriticalResp.builder()
                .criticalSynergyCount(2)
                .criticalPoint(MAX_CRITICAL.subtract(getCritical.add(BigDecimal.valueOf(20)))
                        .divide(BigDecimal.valueOf(0.03579), 0, RoundingMode.UP)
                        .intValue())
                .build());

        return characterClassCriticalRespList;
    }

    @Override
    @Transactional(value = "gameTransactionManager")
    public void insertCharacterClassCritical(CharacterClassCriticalReq characterClassCriticalReq) throws Exception {
        gameMapper.insertCharacterClassCritical(characterClassCriticalReq);
    }

}
