package com.group1.web_games.repo.intermediate_repo;

import com.group1.web_games.model.intermediate.Inventory;
import com.group1.web_games.model.main_entity.GameSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInventoryRepo extends JpaRepository<Inventory,Long> {
    List<Inventory> findInventoryByGameSession (GameSession gameSession);
}
