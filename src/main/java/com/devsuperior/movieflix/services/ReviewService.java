package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTOs.ReviewDTO;
import com.devsuperior.movieflix.DTOs.ReviewResponseDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.repositories.ScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final AuthService authService;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, AuthService authService, ScoreRepository scoreRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.authService = authService;
        this.movieRepository = movieRepository;
    }

   @Transactional
   public ReviewDTO save(ReviewDTO reviewDTO) {
        User user = authService.authenticated();
        Movie movie = movieRepository.getOne(reviewDTO.getMovieId());

       Review review = new Review();
       review.setText(reviewDTO.getText());
       review.setMovie(movie);
       review.setUser(user);

       return new ReviewDTO(reviewRepository.save(review));
   }

   @Transactional
   public ReviewDTO update(ReviewDTO reviewDTO, Long reviewId) {
       User user = authService.authenticated();
       Movie movie = movieRepository.getOne(reviewDTO.getMovieId());
       Review currentReview = reviewRepository.getOne(reviewId);

       currentReview.setText(reviewDTO.getText());
       currentReview.setMovie(movie);
       currentReview.setUser(user);

       return new ReviewDTO(currentReview);
   }
}