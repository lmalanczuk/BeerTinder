package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.repository.BeerRepository;
import com.bt.beertinder.service.BeerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    // Można by użyć Redis lub innej bazy do przechowywania ocen
    private final List<Long> ratedBeers = new ArrayList<>();
    private final List<Long> likedBeers = new ArrayList<>();

    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @Override
    public Beer getBeerById(Long id) {
        return beerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Beer not found with id: " + id));
    }

    @Override
    public Beer addBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    @Override
    public Beer updateBeer(Long id, Beer updatedBeer) {
        Optional<Beer> existingBeer = beerRepository.findById(id);

        if (existingBeer.isPresent()) {
            Beer beer = existingBeer.get();
            beer.setName(updatedBeer.getName());
            beer.setDescription(updatedBeer.getDescription());
            beer.setImageUrl(updatedBeer.getImageUrl());
            return beerRepository.save(beer);
        } else {
            throw new IllegalArgumentException("Beer not found with id: " + id);
        }
    }

    @Override
    public void deleteBeer(Long id) {
        beerRepository.deleteById(id);
    }

    @Override
    public Beer getNextBeer() {
        List<Beer> allBeers = beerRepository.findAll();

        // Filtruj piwa, które nie zostały jeszcze ocenione
        List<Beer> unratedBeers = allBeers.stream()
                .filter(beer -> !ratedBeers.contains(beer.getId()))
                .toList();

        if (unratedBeers.isEmpty()) {
            return null; // Wszystkie piwa zostały ocenione
        }

        // Zwróć losowe piwo z nieocenionych
        Random random = new Random();
        return unratedBeers.get(random.nextInt(unratedBeers.size()));
    }

    @Override
    public void processSwipe(Long beerId, String direction) {
        // Sprawdź czy piwo istnieje
        Beer beer = getBeerById(beerId);

        // Dodaj do ocenionych piw
        ratedBeers.add(beerId);

        // Jeśli użytkownik polubił piwo, dodaj do ulubionych
        if ("like".equalsIgnoreCase(direction)) {
            likedBeers.add(beerId);
        }
    }

    @Override
    public List<Beer> getFavoriteBeers() {
        // Zwróć wszystkie polubione piwa
        return beerRepository.findAllById(likedBeers);
    }
}