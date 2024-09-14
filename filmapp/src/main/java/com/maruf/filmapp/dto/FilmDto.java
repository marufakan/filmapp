package com.maruf.filmapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maruf.filmapp.domain.Film;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {
    private long id;

    @NotBlank(message = "Film adi boş olamaz")
    @Size(min = 2,max = 50,message = "Film adi '${validatevalue}' {min} ve {max} arasinda olmalı!")
    private String filmName;

    @NotBlank(message = "Film yılı boş olamaz")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "Film yapımcısı boş olamaz")
    @Size(min = 2,max = 20,message = "Film yapımcısı '${validatevalue}' {min} ve {max} arasinda olmalı!")
    private String producer;

    @NotBlank(message = "Film türü boş olamaz")
    @Size(min = 2,max = 25,message = "Film türü '${validatevalue}' {min} ve {max} arasinda olmalı!")
    private String genre;

    public FilmDto(Film film) {
        this.id = film.getId();
        this.filmName = film.getFilmName();
        this.releaseYear = film.getReleaseYear();
        this.imdbRating = film.getImdbRating();
        this.producer = film.getProducer();
        this.genre = film.getGenre();
    }
}