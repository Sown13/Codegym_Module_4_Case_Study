package com.group1.web_games.model.main_entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String itemName;
    private int itemStr;
    private int itemInt;
    private int itemVit;
    private int itemMind;
    private String itemSpecial;
    private double itemPrice;
    private String itemImage;

}
