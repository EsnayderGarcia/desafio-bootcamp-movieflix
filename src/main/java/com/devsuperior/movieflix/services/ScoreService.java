package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTOs.ScoreDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Score;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ScoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    private final ScoreRepository scoreRepository;
    private final MovieRepository movieRepository;
    private final AuthService authService;

    public ScoreService(ScoreRepository scoreRepository, MovieRepository movieRepository, AuthService authService) {
        this.scoreRepository = scoreRepository;
        this.movieRepository = movieRepository;
        this.authService = authService;
    }

    @Transactional
    public void save(ScoreDTO scoreDTO) {
        Movie movie = movieRepository.getOne(scoreDTO.getMovieId());
        User user = authService.authenticated();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setScore(scoreDTO.getScore());

        score = scoreRepository.saveAndFlush(score);

        movie.setScore(scoreRepository.getScoreByMovie(scoreDTO.getMovieId()));
        movie = movieRepository.save(movie);
    }
}
