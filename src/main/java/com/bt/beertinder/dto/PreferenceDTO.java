package com.bt.beertinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceDTO {
    private Long id;
    private String beerName;
    private Boolean liked;
}
