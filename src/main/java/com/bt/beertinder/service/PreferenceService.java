package com.bt.beertinder.service;

import com.bt.beertinder.model.PreferenceRequest;
import com.bt.beertinder.model.PreferenceResponse;

import java.util.List;

public interface PreferenceService {

    public void savePreference(PreferenceRequest preferenceRequest);

    public List<PreferenceResponse> getUserPreferences(Long userId);

    public List<PreferenceResponse> getLikedBeers(Long userId);
    }
