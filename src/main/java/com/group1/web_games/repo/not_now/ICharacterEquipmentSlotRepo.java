package com.group1.web_games.repo.not_now;

import com.group1.web_games.model.not_now.CharacterEquipmentSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICharacterEquipmentSlotRepo extends JpaRepository<CharacterEquipmentSlot,Long> {
}
