package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.service.BeerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    public Beer getBeerById(Long id) {
        return beerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Beer not found with id: " + id));
    }

    @Override
    public Beer addBeer(Beer beer) {
        return beerRepository.save(beer);
    }
}
