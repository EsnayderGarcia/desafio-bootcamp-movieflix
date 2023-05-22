package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.DTOs.ScoreDTO;
import com.devsuperior.movieflix.services.ScoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreResource {
    private final ScoreService scoreService;

    public ScoreResource(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PreAuthorize("hasRole('MEMBER')")
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ScoreDTO scoreDTO) {
        scoreService.save(scoreDTO);
        return ResponseEntity.noContent().build();
    }
}
