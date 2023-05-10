package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.DTOs.MovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ScoreRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ScoreRepository scoreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository, ScoreRepository scoreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Filme não Encontrado"));
        return new MovieDTO(movie);
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findMovies(Long genreId, Pageable pageable) {
        Genre genre = genreId == 0 ? null : genreRepository.getOne(genreId);
        return movieRepository.findMovies(genre, pageable).map(MovieDTO::new);
    }
}








