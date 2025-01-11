package com.bt.beertinder.service;

import com.bt.beertinder.dto.BeerDTO;
import com.bt.beertinder.model.Beer;
import com.bt.beertinder.model.Preference;

import java.util.List;

public interface PreferenceService {
    void addPreference(Long userId, Long beerId, Boolean liked);

    public List<BeerDTO> getLikedBeers(Long userId);
}