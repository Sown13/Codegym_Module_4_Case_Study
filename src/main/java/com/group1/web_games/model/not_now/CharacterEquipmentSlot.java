package com.group1.web_games.model.not_now;

import com.group1.web_games.model.main_entity.GameCharacter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterEquipmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterEquipmentSlotId;
    @ManyToOne
    private EquipmentSlot equipmentSlot;
    @ManyToOne
    private GameCharacter gameCharacter;

    public CharacterEquipmentSlot(EquipmentSlot equipmentSlot, GameCharacter gameCharacter) {
        this.equipmentSlot = equipmentSlot;
        this.gameCharacter = gameCharacter;
    }
}
