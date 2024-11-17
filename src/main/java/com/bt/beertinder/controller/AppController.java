package com.bt.beertinder.controller;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.service.BeerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    private final BeerService beerService;

    public AppController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/swipe")
    public String swipe(Model model) {
        Beer beer = beerService.getNextBeer(); // Pobierz kolejne piwo do oceny
        model.addAttribute("beer", beer);
        return "swipe";
    }

    @GetMapping("/favorites")
    public String favorites(Model model) {
        List<Beer> favorites = beerService.getFavoriteBeers(); // Pobierz ulubione piwa
        model.addAttribute("favorites", favorites);
        return "favorites";
    }
}
