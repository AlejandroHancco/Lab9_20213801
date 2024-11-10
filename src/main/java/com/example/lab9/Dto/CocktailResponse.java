package com.example.lab9.Dto;

import com.example.lab9.Entity.Cocktail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CocktailResponse {

    private List<Cocktail> drinks;
}