package com.devsuperior.movieflix.DTOs;

import java.io.Serializable;

public class ScoreDTO implements Serializable {
    private Long movieId;
    private Double score;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
