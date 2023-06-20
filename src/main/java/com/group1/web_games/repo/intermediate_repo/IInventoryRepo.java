package com.group1.web_games.repo.intermediate_repo;

import com.group1.web_games.model.intermediate.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventoryRepo extends JpaRepository<Inventory,Long> {
}
