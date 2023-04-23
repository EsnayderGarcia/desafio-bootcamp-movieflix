package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.DTOs.GenreDTO;
import com.devsuperior.movieflix.services.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreResource {
    private final GenreService genreService;

    public GenreResource(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    private ResponseEntity<List<GenreDTO>> findAll() {
        return ResponseEntity.ok().body(genreService.findAll());
    }
}
