package com.bt.beertinder.service.impl;

import com.bt.beertinder.model.Preference;
import com.bt.beertinder.model.User;
import com.bt.beertinder.repository.PreferenceRepository;
import com.bt.beertinder.service.MatchingService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MatchingServiceImpl implements MatchingService {

    private final PreferenceRepository preferenceRepository;

    public MatchingServiceImpl(PreferenceRepository preferenceRepository) {
        this.preferenceRepository = preferenceRepository;
    }

    @Override
    public Map<String, List<User>> groupUsersByBeer() {
        List<Preference> preferences = preferenceRepository.findAll();

        // Grupowanie użytkowników według ulubionych piw
        return preferences.stream()
                .filter(Preference::getLiked)
                .collect(Collectors.groupingBy(
                        pref -> pref.getBeer().getName(),
                        Collectors.mapping(Preference::getUser, Collectors.toList())
                ));
    }

    @Override
    public List<List<User>> createSubgroups(Map<String, List<User>> groups) {
        List<List<User>> subgroups = new ArrayList<>();

        for (List<User> group : groups.values()) {
            // Dzielimy dużą grupę na mniejsze subgrupy
            if (group.size() > 1) {
                subgroups.add(group);
            }
        }

        return subgroups;
    }

    @Override
    public List<List<User>> pairUsers(List<List<User>> subgroups) {
        List<List<User>> pairs = new ArrayList<>();

        for (List<User> subgroup : subgroups) {
            for (int i = 0; i < subgroup.size() - 1; i += 2) {
                List<User> pair = new ArrayList<>();
                pair.add(subgroup.get(i));
                pair.add(subgroup.get(i + 1));
                pairs.add(pair);
            }
        }

        return pairs;
    }
}
