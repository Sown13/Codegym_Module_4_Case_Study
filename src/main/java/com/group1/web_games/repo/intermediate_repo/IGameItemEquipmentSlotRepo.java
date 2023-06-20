package com.group1.web_games.repo.intermediate_repo;

import com.group1.web_games.model.intermediate.GameItemEquipmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameItemEquipmentSlotRepo extends JpaRepository<GameItemEquipmentSlot,Long> {
}
