package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.CharacterDetail;
import com.group1.web_games.model.main_entity.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICharacterDetailRepo extends JpaRepository<CharacterDetail, Long> {
    //    @Query(value = "SELECT * FROM character_detail cs JOIN game_character gc on gc.character_id = cs.game_character_character_id\n" +
//            "                  JOIN session_character sc ON gc.character_id = sc.game_character_character_id\n" +
//            "                  JOIN game_session gs ON sc.game_session_game_session_id = gs.game_session_id\n" +
//            "WHERE gc.is_alive = true AND  gc.is_enemy = false AND gs.game_session_id = :gameSessionId", nativeQuery = true)
//    List<CharacterDetail> findAliveGameCharacterDetailBySessionId(@Param("gameSessionId") Long gameSessionId);
    @Query("SELECT cs FROM CharacterDetail cs JOIN GameCharacter gc on cs.gameCharacter.characterId = gc.characterId JOIN SessionCharacter sc on gc.characterId = sc.gameCharacter.characterId JOIN GameSession gs on gs.gameSessionId = sc.gameSession.gameSessionId WHERE gc.isAlive = true AND gc.isEnemy = false AND gs.gameSessionId = :gameSessionId")
    List<CharacterDetail> findAlivePlayerDetailBySessionId(@Param("gameSessionId") Long gameSessionId);

    @Query("SELECT cs FROM CharacterDetail cs JOIN GameCharacter gc on cs.gameCharacter.characterId = gc.characterId JOIN SessionCharacter sc on gc.characterId = sc.gameCharacter.characterId JOIN GameSession gs on gs.gameSessionId = sc.gameSession.gameSessionId WHERE gc.isAlive = false AND gc.isEnemy = false AND gs.gameSessionId = :gameSessionId")
    List<CharacterDetail> findDeadPlayerDetailBySessionId(@Param("gameSessionId") Long gameSessionId);

    @Query("SELECT cs FROM CharacterDetail cs JOIN GameCharacter gc on cs.gameCharacter.characterId = gc.characterId JOIN SessionCharacter sc on gc.characterId = sc.gameCharacter.characterId JOIN GameSession gs on gs.gameSessionId = sc.gameSession.gameSessionId WHERE gc.isAlive = true AND gc.isEnemy = true AND gs.gameSessionId = :gameSessionId")
    List<CharacterDetail> findAliveEnemyDetailBySessionId(@Param("gameSessionId") Long gameSessionId);

    @Query("SELECT cs FROM CharacterDetail cs JOIN GameCharacter gc on cs.gameCharacter.characterId = gc.characterId JOIN SessionCharacter sc on gc.characterId = sc.gameCharacter.characterId JOIN GameSession gs on gs.gameSessionId = sc.gameSession.gameSessionId WHERE gc.isAlive = false AND gc.isEnemy = true AND gs.gameSessionId = :gameSessionId")
    List<CharacterDetail> findDeadEnemyDetailBySessionId(@Param("gameSessionId") Long gameSessionId);

    CharacterDetail findCharacterDetailByGameCharacter(GameCharacter gameCharacter);
}
