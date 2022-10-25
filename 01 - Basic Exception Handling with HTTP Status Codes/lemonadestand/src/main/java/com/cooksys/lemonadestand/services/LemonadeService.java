package com.cooksys.lemonadestand.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;

public interface LemonadeService {

    List<LemonadeResponseDto> getAllLemonades();

    ResponseEntity<LemonadeResponseDto> createLemonade(LemonadeRequestDto lemonadeRequestDto);

    ResponseEntity<LemonadeResponseDto> getLemonadeById(Long id);

}
