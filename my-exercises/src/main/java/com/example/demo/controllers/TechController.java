package com.example.demo.controllers;

import com.example.demo.models.TechModel;
import com.example.demo.services.TechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech")
public class TechController {

    @Autowired
    private TechService techService;

    @PostMapping(value = "/create")
    public ResponseEntity<TechModel> createTech(@RequestBody TechModel techModel) {

        techModel = techService.createTech(techModel);


        return ResponseEntity.ok().body(techModel);
    }

    @GetMapping
    public List<TechModel> getAllTechs() {
        return techService.getAllTechs();
    }

    @GetMapping(value = "/{id}")
    public TechModel getTechById(@PathVariable Long id) {
        return techService.getTechById(id);
    }
}
