package com.example.lab9.Controller;


import com.example.lab9.Daos.CocktailDao;
import com.example.lab9.Dto.CocktailResponse;
import com.example.lab9.Entity.Cocktail;
import com.example.lab9.Entity.FavoriteCocktail;
import com.example.lab9.Repository.FavoriteCocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/teleDrink")
public class teleController {

    @Autowired
    private CocktailDao cocktailDao;
    @Autowired
    private FavoriteCocktailRepository favoriteCocktailRepository;


    @GetMapping("/lista")
    public String getCocktailList(Model model) {
        model.addAttribute("cocktails", cocktailDao.bebidaList());
        return "listaComida";
    }
    @GetMapping("/detail/{id}")
    public String getCocktailDetail(@PathVariable String id, Model model) {
        Cocktail cocktail = cocktailDao.cocktailDetail(id);
        model.addAttribute("cocktail", cocktail);
        boolean favorite = favoriteCocktailRepository.existsByFavoriteCocktailId(id);
        model.addAttribute("favorite", favorite);
        return "detailCocktail";
        //
    }

    @PostMapping("/addFavorite")
    public String addToFavorites(@RequestParam("cocktailId") String cocktailId,
                                 @RequestParam("name") String name,
                                 @RequestParam("thumbnail") String thumbnail,
                                 RedirectAttributes redirectAttributes) {

        if (!favoriteCocktailRepository.existsByFavoriteCocktailId(cocktailId)) {
            FavoriteCocktail favorite = new FavoriteCocktail();
            favorite.setFavoriteCocktailId(cocktailId);
            favorite.setName(name);
            favorite.setThumbnail(thumbnail);
            favoriteCocktailRepository.save(favorite);
            redirectAttributes.addFlashAttribute("success", "Favorite saved successfully!");
        } else {
            redirectAttributes.addFlashAttribute("nou", "This drink is already in your favorites.");
        }

        return "redirect:/coctel/detail/" + cocktailId;
    }



}