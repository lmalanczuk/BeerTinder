package com.bt.beertinder.controller;

import com.bt.beertinder.model.Beer;
import com.bt.beertinder.service.BeerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public ResponseEntity<List<Beer>> getAllBeers() {
        return ResponseEntity.ok(beerService.getAllBeers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beer> getBeerById(@PathVariable Long id) {
        return ResponseEntity.ok(beerService.getBeerById(id));
    }

    @PostMapping
    public ResponseEntity<Beer> addBeer(@RequestBody Beer beer) {
        return ResponseEntity.ok(beerService.addBeer(beer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beer> updateBeer(@PathVariable Long id, @RequestBody Beer beer) {
        return ResponseEntity.ok(beerService.updateBeer(id, beer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
        return ResponseEntity.noContent().build();
    }
}