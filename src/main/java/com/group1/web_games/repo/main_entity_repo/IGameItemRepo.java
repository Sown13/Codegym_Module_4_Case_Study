package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGameItemRepo extends JpaRepository<GameItem, Long> {
    @Query("SELECT gi FROM GameItem gi JOIN Inventory iv ON gi.itemId = iv.gameItem.itemId JOIN GameSession gs ON iv.gameSession.gameSessionId = gs.gameSessionId WHERE gs.gameSessionId = :id")
    List<GameItem> findItemByGameSession(@Param("id") Long gameSessionId);

    GameItem findGameItemByItemId (Long gameItemId);
}
