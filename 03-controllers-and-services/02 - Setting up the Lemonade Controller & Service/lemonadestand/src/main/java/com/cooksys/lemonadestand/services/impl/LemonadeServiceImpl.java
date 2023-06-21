package com.cooksys.lemonadestand.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LemonadeServiceImpl implements LemonadeService {

    private LemonadeRepository lemonadeRepository;

    @Override
    public List<Lemonade> getAllLemonades() {
        return lemonadeRepository.findAll();
    }

    @Override
    public Lemonade createLemonade(Lemonade lemonade) {
        lemonade.setPrice(lemonade.getLemonJuice() * .20 + lemonade.getWater() * .01 + lemonade.getSugar() * .15
                + lemonade.getIceCubes() * .05 + .50);
        return lemonadeRepository.saveAndFlush(lemonade);
    }

}
