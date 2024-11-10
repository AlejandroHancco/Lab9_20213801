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

    public List<Cocktail> bebidaList() {
        RestTemplate restTemplate = new RestTemplate();
        String endPoint = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
        ResponseEntity<CocktailResponse> response = restTemplate.getForEntity(endPoint, CocktailResponse.class);
        return response.getBody().getDrinks().stream().limit(12).collect(Collectors.toList());
    }
}



