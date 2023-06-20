package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameSessionRepo extends JpaRepository<GameSession,Long> {
}
