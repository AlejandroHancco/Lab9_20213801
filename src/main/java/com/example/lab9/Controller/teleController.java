package com.example.lab9.Controller;


import com.example.lab9.Daos.CocktailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

}