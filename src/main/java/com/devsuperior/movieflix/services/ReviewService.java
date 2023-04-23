package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTOs.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final AuthService authService;

    public ReviewService(ReviewRepository reviewRepository, AuthService authService) {
        this.reviewRepository = reviewRepository;
        this.authService = authService;
    }

   @Transactional
   public ReviewDTO save(ReviewDTO reviewDTO) {
       Review review = new Review();
       review.setText(reviewDTO.getText());

       Movie movie = new Movie();
       movie.setId(reviewDTO.getMovieId());

       review.setMovie(movie);
       review.setUser(authService.authenticated());

       return new ReviewDTO(reviewRepository.save(review));
   }
}