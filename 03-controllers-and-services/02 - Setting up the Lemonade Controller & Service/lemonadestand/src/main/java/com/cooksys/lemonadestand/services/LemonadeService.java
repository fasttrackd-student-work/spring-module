package com.cooksys.lemonadestand.services;

import java.util.List;

import com.cooksys.lemonadestand.entities.Lemonade;

public interface LemonadeService {

    List<Lemonade> getAllLemonades();

    Lemonade createLemonade(Lemonade lemonade);

}
