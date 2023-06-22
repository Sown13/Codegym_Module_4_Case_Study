package com.group1.web_games.model.intermediate;

import com.group1.web_games.model.main_entity.GameSession;
import com.group1.web_games.model.main_entity.GameItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @ManyToOne
    private GameSession gameSession;
    @ManyToOne
    private GameItem gameItem;
    private String inventoryImage;


    public Inventory(GameSession gameSession) {
        this.gameSession = gameSession;
    }
}
