package com.example.springdatarelational32.controllers;

import com.example.springdatarelational32.model.ChinsEntity;
import com.example.springdatarelational32.repos.ChinsRepository;
import org.springframework.data.domain.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChinsController {

    private final ChinsRepository chinsRepository;

    public ChinsController(ChinsRepository chinsRepository) {
        this.chinsRepository = chinsRepository;
    }

    @GetMapping("/color_limited/{color}/{limit:\\d}")
    public List<ChinsEntity> color_limited(@PathVariable String color, @PathVariable int limit) {
        return chinsRepository.findChinsEntitiesByColorIsLike("%"+color+"%", Limit.of(limit));

    }

    @GetMapping("/color")
    public List<ChinsEntity> color() {
        return chinsRepository.someQuery();
    }
}
