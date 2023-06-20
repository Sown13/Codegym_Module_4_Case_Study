package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.GameItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGameItemRepo extends JpaRepository<GameItem, Long> {
}
