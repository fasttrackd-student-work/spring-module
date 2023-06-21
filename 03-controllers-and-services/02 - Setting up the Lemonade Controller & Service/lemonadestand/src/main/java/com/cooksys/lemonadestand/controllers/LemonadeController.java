package com.cooksys.lemonadestand.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.lemonadestand.entities.Lemonade;
import com.cooksys.lemonadestand.services.LemonadeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/lemonades")
@AllArgsConstructor
public class LemonadeController {

    private LemonadeService lemonadeService;

    @GetMapping
    public List<Lemonade> getAllLemonades() {
        return lemonadeService.getAllLemonades();
    }

    @PostMapping
    public Lemonade createLemonade(@RequestBody Lemonade lemonade) {
        return lemonadeService.createLemonade(lemonade);
    }

}
