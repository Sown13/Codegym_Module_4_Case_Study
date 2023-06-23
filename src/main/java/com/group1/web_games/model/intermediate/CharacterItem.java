package com.group1.web_games.model.intermediate;

import com.group1.web_games.model.main_entity.GameCharacter;
import com.group1.web_games.model.main_entity.GameItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CharacterItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long characterItemId;
    @ManyToOne
    private GameItem gameItem;
    @ManyToOne
    private GameCharacter gameCharacter;

    public CharacterItem(GameCharacter gameCharacter) {
        this.gameCharacter = gameCharacter;
    }
}
