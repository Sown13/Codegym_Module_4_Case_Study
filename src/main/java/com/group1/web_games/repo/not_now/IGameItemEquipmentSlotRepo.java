package com.group1.web_games.repo.not_now;

import com.group1.web_games.model.not_now.GameItemEquipmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGameItemEquipmentSlotRepo extends JpaRepository<GameItemEquipmentSlot,Long> {
}
