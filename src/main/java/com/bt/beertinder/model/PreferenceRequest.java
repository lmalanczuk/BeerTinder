package com.bt.beertinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceRequest {
    private Long userId;
    private Long beerId;
    private Boolean liked;
}
