package com.bt.beertinder.service;

import com.bt.beertinder.model.Beer;
import java.util.List;

public interface BeerService {
    List<Beer> getAllBeers();
    Beer getBeerById(Long id);
    Beer addBeer(Beer beer);
}