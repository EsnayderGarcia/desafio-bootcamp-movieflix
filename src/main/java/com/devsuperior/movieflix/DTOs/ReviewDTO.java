package com.devsuperior.movieflix.DTOs;

import com.devsuperior.movieflix.entities.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ReviewDTO implements Serializable {
    private Long idReview;

    @NotBlank(message = "O texto é obrigatório")
    private String text;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long movieId;

    private LocalDateTime postMoment;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        idReview = review.getId();
        text = review.getText();
        userName = review.getUser().getName();
        movieId = review.getMovie().getId();
        postMoment = review.getPostMoment();
    }

    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
        this.idReview = idReview;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getPostMoment() {
        return postMoment;
    }

    public void setPostMoment(LocalDateTime postMoment) {
        this.postMoment = postMoment;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
