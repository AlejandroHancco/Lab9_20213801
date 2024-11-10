package com.example.lab9.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetailCocktail {
    private String strDrink;
    private String strThumb;
    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;
    private List<String> strIngredients;
    private List<String> strMeasures;
}