package com.cooksys.lemonadestand.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.exceptions.BadRequestException;
import com.cooksys.lemonadestand.exceptions.NotFoundException;
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
        if (lemonadeRequestDto.getLemonJuice() == null || lemonadeRequestDto.getWater() == null
                || lemonadeRequestDto.getSugar() == null || lemonadeRequestDto.getIceCubes() == null) {
            throw new BadRequestException("All fields are required for creating a lemonade");
        }

        Lemonade lemonadeToSave = lemonadeMapper.requestDtoToEntity(lemonadeRequestDto);
        lemonadeToSave.setPrice(
                lemonadeToSave.getLemonJuice() * .20 + lemonadeToSave.getWater() * .01 + lemonadeToSave.getSugar() * .15
                        + lemonadeToSave.getIceCubes() * .05 + .50);
        return lemonadeMapper.entityToResponseDto(lemonadeRepository.saveAndFlush(lemonadeToSave));
    }

    @Override
    public LemonadeResponseDto getLemonadeById(Long id) {
        Optional<Lemonade> optionalLemonade = lemonadeRepository.findById(id);
        if (optionalLemonade.isEmpty()) {
            // In the video I put the message "No user found with id" + id.
            // I should have made it no lemonade found so I corrected it in the code.
            throw new NotFoundException("No lemonade found with id: " + id);
        }
        return lemonadeMapper.entityToResponseDto(optionalLemonade.get());
    }

}
