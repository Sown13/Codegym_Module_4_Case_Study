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
}
