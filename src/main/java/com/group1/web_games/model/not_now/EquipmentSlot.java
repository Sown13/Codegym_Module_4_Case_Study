package com.group1.web_games.model.not_now;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentSlotId;
    private String equipmentSlotName;
    private String equipmentSlotImage;
}
