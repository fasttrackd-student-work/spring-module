package com.cooksys.lemonadestand.services;

import java.util.List;

import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;

public interface LemonadeStandService {

    LemonadeStand getLemonadeStand(Long id);

    LemonadeStandResponseDto createLemonadeStand(LemonadeStandRequestDto lemonadeStandRequestDto);

    List<LemonadeStandResponseDto> getAllLemonadeStands();

    LemonadeStandResponseDto getLemonadeStandById(Long id);

    LemonadeStandResponseDto updateLemonadeStand(Long id, LemonadeStandRequestDto lemonadeStandRequestDto);

    LemonadeStandResponseDto deleteLemonadeStand(Long id);

}
