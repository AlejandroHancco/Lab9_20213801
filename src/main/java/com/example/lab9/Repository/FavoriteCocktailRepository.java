package com.example.lab9.Repository;

import com.example.lab9.Entity.FavoriteCocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteCocktailRepository extends JpaRepository<FavoriteCocktail, Integer> {


    boolean existsByFavoriteCocktailId(String cocktailId);
}
