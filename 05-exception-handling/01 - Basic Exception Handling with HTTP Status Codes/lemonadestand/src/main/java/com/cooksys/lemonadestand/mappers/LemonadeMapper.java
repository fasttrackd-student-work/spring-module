package com.cooksys.lemonadestand.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;

@Mapper(componentModel = "spring")
public interface LemonadeMapper {

    Lemonade requestDtoToEntity(LemonadeRequestDto lemonadeRequestDto);

    LemonadeResponseDto entityToResponseDto(Lemonade lemonade);

    List<LemonadeResponseDto> entitiesToResponseDtos(List<Lemonade> lemonades);

}
