package com.example.lab9.Controller;


import com.example.lab9.Daos.CocktailDao;
import com.example.lab9.Dto.CocktailResponse;
import com.example.lab9.Entity.Cocktail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/teleDrink")
public class teleController {

    @Autowired
    private CocktailDao cocktailDao;


    @GetMapping("/lista")
    public String getCocktailList(Model model) {
        model.addAttribute("cocktails", cocktailDao.bebidaList());
        return "listaComida";
    }
    @GetMapping("/detail/{id}")
    public String getCocktailDetail(@PathVariable String id, Model model) {
        Cocktail cocktail = cocktailDao.cocktailDetail(id);
        model.addAttribute("cocktail", cocktail);
        return "detailCocktail";
    }


}