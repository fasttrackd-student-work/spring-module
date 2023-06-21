package com.cooksys.lemonadestand.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.lemonadestand.model.LemonadeRequestDto;
import com.cooksys.lemonadestand.model.LemonadeResponseDto;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lemonades")
@AllArgsConstructor
public class LemonadeController {

    private LemonadeService lemonadeService;

    @GetMapping
    public List<LemonadeResponseDto> getAllLemonades() {
        return lemonadeService.getAllLemonades();
    }

    @PostMapping
    public ResponseEntity<LemonadeResponseDto> createLemonade(@RequestBody LemonadeRequestDto lemonadeRequestDto) {
        return lemonadeService.createLemonade(lemonadeRequestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LemonadeResponseDto> getLemonadeById(@PathVariable Long id) {
        return lemonadeService.getLemonadeById(id);
    }

}
