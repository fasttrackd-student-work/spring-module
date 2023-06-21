package com.cooksys.lemonadestand.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

// If you want to use this version of the service, uncomment it's @Service annotation and comment out the @Service annotation in the regular impl class
// @Service
@AllArgsConstructor
public class LemonadeServiceManualMappingImpl implements LemonadeService {

    private LemonadeRepository lemonadeRepository;

    @Override
    public List<LemonadeResponseDto> getAllLemonades() {
        List<LemonadeResponseDto> result = new ArrayList<>();
        for (Lemonade lemonade : lemonadeRepository.findAll()) {
            result.add(new LemonadeResponseDto(lemonade.getId(), lemonade.getLemonJuice(), lemonade.getWater(),
                    lemonade.getSugar(), lemonade.getIceCubes(), lemonade.getPrice()));
        }
        return result;
    }

    @Override
    public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {

        // Map the request dto to a lemonade entity
        Lemonade lemonadeToSave = new Lemonade();
        lemonadeToSave.setLemonJuice(lemonadeRequestDto.getLemonJuice());
        lemonadeToSave.setWater(lemonadeRequestDto.getWater());
        lemonadeToSave.setSugar(lemonadeRequestDto.getSugar());
        lemonadeToSave.setIceCubes(lemonadeRequestDto.getIceCubes());
        lemonadeToSave.setPrice(
                lemonadeToSave.getLemonJuice() * .20 + lemonadeToSave.getWater() * .01 + lemonadeToSave.getSugar() * .15
                        + lemonadeToSave.getIceCubes() * .05 + .50);

        // save the new lemonade entity and store the resulting entitiy with the ID
        // generated from the database in a variable named savedLemonade
        Lemonade savedLemonade = lemonadeRepository.saveAndFlush(lemonadeToSave);

        // create and return a new LemonadeResponseDto using the ID and price from the
        // saved lemonade entity
        return new LemonadeResponseDto(savedLemonade.getId(), savedLemonade.getLemonJuice(), savedLemonade.getWater(),
                savedLemonade.getSugar(), savedLemonade.getIceCubes(), savedLemonade.getPrice());
    }

}
