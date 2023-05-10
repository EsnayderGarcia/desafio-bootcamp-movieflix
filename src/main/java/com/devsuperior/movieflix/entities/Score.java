package com.devsuperior.movieflix.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_score")
public class Score implements Serializable {
    @EmbeddedId
    private ScorePk id = new ScorePk();
    private Double score;

    public ScorePk getId() {
        return id;
    }

    public void setId(ScorePk id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setMovie(Movie movie) {
        id.setMovie(movie);
    }

    public void setUser(User user) {
        id.setUser(user);
    }
}
