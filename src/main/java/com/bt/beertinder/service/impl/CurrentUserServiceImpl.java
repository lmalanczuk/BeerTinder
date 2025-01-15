package com.bt.beertinder.service.impl;

import com.bt.beertinder.dto.UserProfileDTO;
import com.bt.beertinder.service.CurrentUserService;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    public String getCurrentUsername() {
        return "lukasz_malanczuk";
    }
    public UserProfileDTO getCurrentUserProfile() {
        return new UserProfileDTO(22L, "lukasz_malanczuk", "lukasz_malanczuk@example.com", null);
    }
}
