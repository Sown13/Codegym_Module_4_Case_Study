package com.group1.web_games.service.main_entity_service.skill;

import com.group1.web_games.model.main_entity.Skill;
import com.group1.web_games.service.IGeneralService;

import java.util.List;

public interface ISkillService extends IGeneralService<Skill> {
    List<Skill> findSkillByAliveCharacterAndGameSession(Long id);
    List<Skill> findSkillBycharacterIdAndGameSession(Long gameSessionId,Long characterId);
}
