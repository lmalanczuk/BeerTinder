package com.bt.beertinder.service;

import com.bt.beertinder.model.Preference;

public interface PreferenceService {
    void addPreference(Long userId, Long beerId, Boolean liked);
}