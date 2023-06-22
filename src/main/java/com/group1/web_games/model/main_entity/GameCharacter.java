package com.group1.web_games.model.main_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterId;
    private String characterName;
    private int characterLevel;
    private int characterExp;
    private String characterType;
    private int characterStr;
    private int characterInt;
    private int characterVit;
    private int characterMind;
    private int statPoint;
    private int skillPoint;
    private String characterImage;
    private boolean isAlive;
    private boolean isEnemy;

    public GameCharacter(String characterName, int characterLevel, int characterExp, String characterType, int characterStr, int characterInt, int characterVit, int characterMind, int statPoint, int skillPoint, String characterImage, boolean isAlive) {
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.characterExp = characterExp;
        this.characterType = characterType;
        this.characterStr = characterStr;
        this.characterInt = characterInt;
        this.characterVit = characterVit;
        this.characterMind = characterMind;
        this.statPoint = statPoint;
        this.skillPoint = skillPoint;
        this.characterImage = characterImage;
        this.isAlive = isAlive;
    }
}
