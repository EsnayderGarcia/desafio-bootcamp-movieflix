package com.devsuperior.movieflix.DTOs;

import com.devsuperior.movieflix.entities.Genre;

import java.util.Objects;

public class GenreDTO {
    private Long id;
    private String name;

    public GenreDTO(Genre genre) {
        this.id = genre.getId();
        this.name = genre.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreDTO genreDTO = (GenreDTO) o;
        return Objects.equals(id, genreDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
