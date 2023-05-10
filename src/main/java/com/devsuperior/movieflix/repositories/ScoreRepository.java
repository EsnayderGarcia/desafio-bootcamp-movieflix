package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Score;
import com.devsuperior.movieflix.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
    @Query("SELECT ROUND(AVG(obj.score), 2) FROM Score obj WHERE obj.id.movie.id = :movieId")
    Double getScoreByMovie(Long movieId);
}
