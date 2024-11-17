package com.bt.beertinder.controller;

import com.bt.beertinder.service.BeerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/beers")
public class BeerApiController {

    private final BeerService beerService;

    public BeerApiController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping("/swipe")
    public void swipeBeer(@RequestBody SwipeRequest swipeRequest) {
        beerService.processSwipe(swipeRequest.getBeerId(), swipeRequest.getDirection());
    }

    // DTO dla requestu
    static class SwipeRequest {
        private Long beerId;
        private String direction; // "like" lub "dislike"

        // Gettery i settery
        public Long getBeerId() {
            return beerId;
        }

        public void setBeerId(Long beerId) {
            this.beerId = beerId;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }
    }
}
