package com.group1.web_games.model.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 6, max = 32)
    private String username;

    @NotNull
    @Size(min = 6, max = 8)
    private String password;

    @Size(max = 50)
    @Email
    private String email;

    private boolean aBoolean;



    public User() {
    }

}

