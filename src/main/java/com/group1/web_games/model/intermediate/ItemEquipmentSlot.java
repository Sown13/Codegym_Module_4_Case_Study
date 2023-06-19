package com.group1.web_games.model.intermediate;

import com.group1.web_games.model.main_entity.EquipmentSlot;
import com.group1.web_games.model.main_entity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemEquipmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemEquipmentSlotId;
    @ManyToOne
    private EquipmentSlot equipmentSlot;
    @ManyToOne
    private Item item;
}
