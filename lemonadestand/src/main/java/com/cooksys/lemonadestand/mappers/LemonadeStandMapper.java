package com.cooksys.lemonadestand.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.lemonadestand.entities.LemonadeStand;
import com.cooksys.lemonadestand.model.LemonadeStandDto;
import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;

@Mapper(componentModel = "spring")
public interface LemonadeStandMapper {

    LemonadeStand requestDtoToEntity(LemonadeStandRequestDto lemonadeStandRequestDto);

    LemonadeStand lemonadeStandDtoToEntity(LemonadeStandDto lemonadeStandDto);

    LemonadeStandResponseDto entityToResponseDto(LemonadeStand lemonadeStand);

    List<LemonadeStandResponseDto> entitiesToResponseDtos(List<LemonadeStand> lemonadeStands);

}
