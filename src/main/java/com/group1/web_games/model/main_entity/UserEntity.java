package com.group1.web_games.model.main_entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userFullName;
    private String email;
    private String phone;
    private String accountName;
    private String accountPassword;
    private String userAvatar;
    private boolean block;
}
