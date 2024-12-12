package com.bt.beertinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceResponse {
    private Long beerId;
    private String beerName;
    private Boolean liked;
}
