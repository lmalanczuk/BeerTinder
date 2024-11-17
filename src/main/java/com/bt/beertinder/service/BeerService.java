package com.bt.beertinder.service;


import com.bt.beertinder.model.Beer;

import java.util.List;

public interface BeerService {

    List<Beer> getAllBeers();

    Beer getBeerById(Long id);

    Beer addBeer(Beer beer);

    Beer updateBeer(Long id, Beer beer);

    void deleteBeer(Long id);

    Beer getNextBeer(); // Pobiera kolejne piwo do oceny

    void processSwipe(Long beerId, String direction); // Obsługuje swipe

    List<Beer> getFavoriteBeers(); // Pobiera ulubione piwa użytkownika
}