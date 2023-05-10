package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.DTOs.ReviewDTO;
import com.devsuperior.movieflix.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reviews")
public class ReviewResource {
    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PreAuthorize("hasRole('MEMBER')")
    @PostMapping
    public ResponseEntity<ReviewDTO> save(@RequestBody @Valid ReviewDTO reviewDTO) {
        return new ResponseEntity<>(reviewService.save(reviewDTO), HttpStatus.CREATED);
    }
}
