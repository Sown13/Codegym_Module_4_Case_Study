package com.group1.web_games.repo.main_entity_repo;

import com.group1.web_games.model.main_entity.EquipmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipmentSlotRepo extends JpaRepository<EquipmentSlot,Long> {
}
