package com.cooksys.lemonadestand.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.lemonadestand.model.LemonadeStandRequestDto;
import com.cooksys.lemonadestand.model.LemonadeStandResponseDto;
import com.cooksys.lemonadestand.services.LemonadeStandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("lemonadestands")
@RequiredArgsConstructor
public class LemonadeStandController {

    private final LemonadeStandService lemonadeStandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LemonadeStandResponseDto createLemonadeStand(@RequestBody LemonadeStandRequestDto lemonadeStandRequestDto) {
        return lemonadeStandService.createLemonadeStand(lemonadeStandRequestDto);
    }

    @GetMapping
    public List<LemonadeStandResponseDto> getAllLemonadeStands() {
        return lemonadeStandService.getAllLemonadeStands();
    }

    @GetMapping("/{id}")
    public LemonadeStandResponseDto getLemonadeStandById(@PathVariable Long id) {
        return lemonadeStandService.getLemonadeStandById(id);
    }

    @PatchMapping("/{id}")
    public LemonadeStandResponseDto updateLemonadeStand(@PathVariable Long id,
            @RequestBody LemonadeStandRequestDto lemonadeStandRequestDto) {
        return lemonadeStandService.updateLemonadeStand(id, lemonadeStandRequestDto);
    }

    @DeleteMapping("/{id}")
    public LemonadeStandResponseDto deleteLemonadeStand(@PathVariable Long id) {
        return lemonadeStandService.deleteLemonadeStand(id);
    }

}
