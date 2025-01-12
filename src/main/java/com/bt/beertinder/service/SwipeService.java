package com.bt.beertinder.service;

import com.bt.beertinder.dto.UserSwipeDTO;

public interface SwipeService {
    UserSwipeDTO processSwipe(Long userId, Long targetUserId, Boolean liked);
}
