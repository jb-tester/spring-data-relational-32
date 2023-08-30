package com.example.springdatarelational32.controllers;

import com.example.springdatarelational32.model.ChinsEntity;
import com.example.springdatarelational32.repos.ChinsRepo;
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
    private final ChinsRepo chinsRepo;

    public ChinsController(ChinsRepository chinsRepository, ChinsRepo chinsRepo) {
        this.chinsRepository = chinsRepository;
        this.chinsRepo = chinsRepo;
    }

    @GetMapping("/color_limited/{color}/{limit:\\d}")
    public List<ChinsEntity> color_limited(@PathVariable String color, @PathVariable int limit) {
        return chinsRepository.findChinsEntitiesByColorIsLike("%"+color+"%", Limit.of(limit));

    }

    @GetMapping("/color")
    public List<ChinsEntity> color() {
        return chinsRepository.someQuery();
    }

    @GetMapping("/all/{limit:\\d}")
    public List<ChinsEntity> allLimited(@PathVariable int limit) {
        System.out.println("all limited by "+limit);
        return chinsRepository.findAllBy(Limit.of(limit));
    }

    @GetMapping("/all")
    public List<ChinsEntity> all() {
        return chinsRepo.findAll();
    }

    @GetMapping("/byName/{name}")
    public List<ChinsEntity> byName(@PathVariable("name") String name) {
        return chinsRepo.findByName(name);
    }
}
