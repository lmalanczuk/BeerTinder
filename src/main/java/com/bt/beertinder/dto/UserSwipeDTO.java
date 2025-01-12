package com.bt.beertinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSwipeDTO {
    private Long userId;
    private Long targetUserId;
    private Boolean liked;
}
