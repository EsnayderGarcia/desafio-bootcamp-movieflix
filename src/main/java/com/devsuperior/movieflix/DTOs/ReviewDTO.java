package com.devsuperior.movieflix.DTOs;

import com.devsuperior.movieflix.entities.Review;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

public class ReviewDTO implements Serializable {
    private Long id;

    @NotBlank(message = "Campo requerido")
    private String text;
    private UserDTO user;
    private Long movieId;
    private Double score;

    public ReviewDTO() {
    }

    public ReviewDTO(Long id, String text, UserDTO user, Long movieId) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.movieId = movieId;
    }

    public ReviewDTO(Review review) {
        id = review.getId();
        text = review.getText();
        user = new UserDTO(review.getUser());
        movieId = review.getMovie().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDTO reviewDTO = (ReviewDTO) o;
        return Objects.equals(id, reviewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
