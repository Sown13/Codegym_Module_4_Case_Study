package com.group1.web_games.model.main_entity;

import com.group1.web_games.model.main_entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameSessionId;
    private String gameSessionName;
    private double money;
    @ManyToOne
    private User user;
    private String gameSessionImage;

}
