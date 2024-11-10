package com.example.lab9.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "favoritecocktail")
public class FavoriteCocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "favoriteCocktailId", nullable = false, length = 120)
    private String favoriteCocktailId;

    @Column(name = "name", nullable = false, length = 120)
    private String name;

    @Column(name = "thumbnail", nullable = false, length = 120)
    private String thumbnail;

    @Column(name = "isFavorito", nullable = false)
    private boolean isFavorito;

}