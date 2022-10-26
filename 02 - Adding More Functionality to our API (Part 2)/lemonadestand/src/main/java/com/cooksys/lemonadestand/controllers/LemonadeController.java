package com.cooksys.lemonadestand.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public LemonadeResponseDto createLemonade(@RequestBody LemonadeRequestDto lemonadeRequestDto) {
        return lemonadeService.createLemonade(lemonadeRequestDto);
    }

    @GetMapping("/{id}")
    public LemonadeResponseDto getLemonadeById(@PathVariable Long id) {
        return lemonadeService.getLemonadeById(id);
    }

    @PutMapping("/{id}")
    public LemonadeResponseDto updateLemonade(@PathVariable Long id,
            @RequestBody LemonadeRequestDto lemonadeRequestDto) {
        return lemonadeService.updateLemonade(id, lemonadeRequestDto);
    }

    @DeleteMapping("/{id}")
    public LemonadeResponseDto deleteLemonade(@PathVariable Long id) {
        return lemonadeService.deleteLemonade(id);
    }

}
