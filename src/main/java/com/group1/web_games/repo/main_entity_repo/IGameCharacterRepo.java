package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;

@Repository
public interface IGameCharacterRepo extends JpaRepository<GameCharacter,Long> {
    @Modifying
    @Query("DELETE FROM EquipmentSlot c WHERE c.equipmentSlotId IN (SELECT ce.equipmentSlot.equipmentSlotId FROM CharacterEquipmentSlot ce WHERE ce.gameCharacter.characterId = :characterId)")
    void deleteCharacterEquipmentSlotByCharacterId(@Param("characterId") Long characterId);

//    @Query("SELECT gc FROM GameCharacter gc JOIN SessionCharacter sc ON gc.characterId = sc.characterId JOIN GameSession gs ON sc.sessionId = gs.id WHERE gs.id = :sessionId")
//    LinkedList<GameCharacter> showPartyBySession(@Param("gameSessionId")Long gameSessionId);
}
