package com.cooksys.lemonadestand.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LemonadeRequestDto {

    private Double lemonJuice;

    private Double water;

    private Double sugar;

    private Integer iceCubes;

}
