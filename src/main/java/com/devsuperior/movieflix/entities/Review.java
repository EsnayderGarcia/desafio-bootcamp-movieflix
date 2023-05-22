package com.devsuperior.movieflix.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_review")
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private LocalDateTime postMoment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String authority) {
        this.text = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getPostMoment() {
        return postMoment;
    }

    public void setPostMoment(LocalDateTime postMoment) {
        this.postMoment = postMoment;
    }

    @PrePersist
    public void prePersist() {
        postMoment = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        postMoment = LocalDateTime.now();
    }
}
