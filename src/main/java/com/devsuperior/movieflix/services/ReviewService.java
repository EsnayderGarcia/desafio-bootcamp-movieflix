package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTOs.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.Score;
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
    private final ScoreRepository scoreRepository;
    private final MovieRepository movieRepository;

    public ReviewService(ReviewRepository reviewRepository, AuthService authService, ScoreRepository scoreRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.authService = authService;
        this.scoreRepository = scoreRepository;
        this.movieRepository = movieRepository;
    }

   @Transactional
   public ReviewDTO save(ReviewDTO reviewDTO) {
        User user = authService.authenticated();
        Movie movie = movieRepository.getOne(reviewDTO.getMovieId());

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setScore(reviewDTO.getScore());

        scoreRepository.save(score);

        movie.setScore(scoreRepository.getScoreByMovie(movie.getId()));
        movie = movieRepository.saveAndFlush(movie);

       Review review = new Review();
       review.setText(reviewDTO.getText());
       review.setMovie(movie);
       review.setUser(user);

       return new ReviewDTO(reviewRepository.save(review));
   }
}