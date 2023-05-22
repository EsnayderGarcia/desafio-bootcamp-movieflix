package com.devsuperior.movieflix.DTOs;

import com.devsuperior.movieflix.entities.Review;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ReviewResponseDTO implements Serializable {
    private Long idReview;
    private String text;
    private String userName;
    private LocalDateTime postMoment;

    public ReviewResponseDTO(Review review) {
        idReview = review.getId();
        text = review.getText();
        userName = review.getUser().getName();
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
}
