package com.bt.beertinder.service;

import com.bt.beertinder.model.User;

import java.util.List;
import java.util.Map;

public interface MatchingService {

    Map<String, List<User>> groupUsersByBeer();

    List<List<User>> createSubgroups(Map<String, List<User>> groups);

    List<List<User>> pairUsers(List<List<User>> subgroups);
}
