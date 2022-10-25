package com.cooksys.lemonadestand.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LemonadeRequestDto {

    private double lemonJuice;

    private double water;

    private double sugar;

    private int iceCubes;

}
