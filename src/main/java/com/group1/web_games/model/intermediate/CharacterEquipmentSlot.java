package com.group1.web_games.model.intermediate;

import com.group1.web_games.model.main_entity.Character;
import com.group1.web_games.model.main_entity.EquipmentSlot;
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
    private Character character;
}
