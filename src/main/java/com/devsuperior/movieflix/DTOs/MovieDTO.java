package com.devsuperior.movieflix.DTOs;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieDTO {
    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
    private String synopsis;
    private GenreDTO genre;
    private Double score;
    private final List<ReviewDTO> reviews = new ArrayList<>();

    public MovieDTO(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        subTitle = movie.getSubTitle();
        year = movie.getYear();
        imgUrl = movie.getImgUrl();
        synopsis = movie.getSynopsis();
        score = movie.getScore();

        genre = new GenreDTO(movie.getGenre());
    }

    public MovieDTO(Movie movie, List<Review> reviews) {
        this(movie);
        reviews.stream().forEach(r -> this.reviews.add(new ReviewDTO(r)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<ReviewDTO> getReviews() {
        return reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(id, movieDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
