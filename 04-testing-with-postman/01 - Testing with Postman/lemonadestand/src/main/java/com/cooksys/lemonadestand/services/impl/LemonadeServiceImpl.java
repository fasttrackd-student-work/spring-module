package com.cooksys.lemonadestand.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.mappers.LemonadeMapper;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.repositories.LemonadeRepository;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LemonadeServiceImpl implements LemonadeService {

    private LemonadeRepository lemonadeRepository;
    private LemonadeMapper lemonadeMapper;

    @Override
    public List<LemonadeResponseDto> getAllLemonades() {
        return lemonadeMapper.entitiesToResponseDtos(lemonadeRepository.findAll());
    }

    @Override
    public LemonadeResponseDto createLemonade(LemonadeRequestDto lemonadeRequestDto) {
        Lemonade lemonadeToSave = lemonadeMapper.requestDtoToEntity(lemonadeRequestDto);
        lemonadeToSave.setPrice(
                lemonadeToSave.getLemonJuice() * .20 + lemonadeToSave.getWater() * .01 + lemonadeToSave.getSugar() * .15
                        + lemonadeToSave.getIceCubes() * .05 + .50);
        return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToSave));
    }

    @Override
    public LemonadeResponseDto getLemonadeById(Long id) {
        // In the video I use getOne, but if you try that you'll see it's deprecated.
        // Instead use getReferenceById here.
        // Feel free to read it's Java Docs to see what it does.
        return lemonadeMapper.entityToResponseDto(lemonadeRepository.getReferenceById(id));
    }

}
