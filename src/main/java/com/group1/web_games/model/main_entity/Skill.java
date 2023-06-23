package com.group1.web_games.model.main_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;
    private String skillName;
    private String skillType;
    private String skillSpecial;
    private int skillCost;
    private int skillLevel;
    private String skillImage;
    @ManyToOne
    private GameCharacter gameCharacter;

    public Skill(String skillName, String skillType, String skillSpecial, int skillCost, int skillLevel, String skillImage, GameCharacter gameCharacter) {
        this.skillName = skillName;
        this.skillType = skillType;
        this.skillSpecial = skillSpecial;
        this.skillCost = skillCost;
        this.skillLevel = skillLevel;
        this.skillImage = skillImage;
        this.gameCharacter = gameCharacter;
    }
}
