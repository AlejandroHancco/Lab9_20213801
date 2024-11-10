package com.example.lab9.Daos;

import com.example.lab9.Dto.CocktailResponse;

import com.example.lab9.Entity.Cocktail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CocktailDao {
    RestTemplate restTemplate = new RestTemplate();
    public List<Cocktail> bebidaList() {
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        ResponseEntity<CocktailResponse> response = restTemplate.getForEntity(endPoint, CocktailResponse.class);
        return response.getBody().getDrinks().stream().limit(12).collect(Collectors.toList());
    }
    public Cocktail cocktailDetail (String id) {
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";
        CocktailResponse response = restTemplate.getForObject(endPoint + id, CocktailResponse.class);
        return response != null && !response.getDrinks().isEmpty() ? response.getDrinks().get(0) : null;
    }
}



