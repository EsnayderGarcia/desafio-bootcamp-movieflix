package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.DTOs.MovieDTO;
import com.devsuperior.movieflix.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    private final MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<MovieDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(movieService.findById(id));
    }

    @GetMapping("/{movieId}/reviews")
    private ResponseEntity<MovieDTO> findReviewsByMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok().body(movieService.findReviewsByMovie(movieId));
    }

    @GetMapping
    private ResponseEntity<Page<MovieDTO>> findMovies(@RequestParam(defaultValue = "0") Long genreId, Pageable pageable) {
        return ResponseEntity.ok().body(movieService.findMovies(genreId, pageable));
    }
}
