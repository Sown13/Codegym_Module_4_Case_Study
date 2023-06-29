package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkillRepo extends JpaRepository<Skill, Long> {
    @Query("SELECT sk from Skill sk JOIN GameCharacter gc on sk.gameCharacter.characterId = gc.characterId JOIN SessionCharacter sc ON sc.gameCharacter.characterId = gc.characterId where gc.isAlive = true and gc.isEnemy = false and sc.gameSession.gameSessionId = :id")
    List<Skill> findSkillsByGameCharacterAlive(@Param("id") Long id);
    @Query("SELECT sk from Skill sk JOIN GameCharacter gc on sk.gameCharacter.characterId = gc.characterId JOIN SessionCharacter sc ON sc.gameCharacter.characterId = gc.characterId where gc.isAlive = true and gc.isEnemy = false and sc.gameSession.gameSessionId = :gameSessionId and gc.characterId = :characterId")
    List<Skill> findSkillsByGameCharacterAndGameSession(@Param("gameSessionId") Long gameSessionId,@Param("characterId") Long characterId);
}
