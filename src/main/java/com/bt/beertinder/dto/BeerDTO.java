package com.bt.beertinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeerDTO {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
}