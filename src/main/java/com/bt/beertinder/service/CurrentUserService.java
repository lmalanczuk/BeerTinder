package com.bt.beertinder.service;

import com.bt.beertinder.dto.UserProfileDTO;

public interface CurrentUserService {

    String getCurrentUsername();
    UserProfileDTO getCurrentUserProfile();
}

