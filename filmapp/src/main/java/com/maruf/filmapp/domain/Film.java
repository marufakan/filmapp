package com.maruf.filmapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Setter(AccessLevel.NONE)
    private long id;

    @NotBlank(message = "Film adi boş olamaz")
    @Size(min = 2,max = 50,message = "Film adi '${validatevalue}' {min} ve {max} arasinda olmalı!")
    @Column(nullable = false, length = 50)
    private String filmName;

    @NotBlank(message = "Film yılı boş olamaz")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private String releaseYear;

    private Double imdbRating;

    @NotBlank(message = "Film yapımcısı boş olamaz")
    @Size(min = 2,max = 20,message = "Film yapımcısı '${validatevalue}' {min} ve {max} arasinda olmalı!")
    @Column(nullable = false, length = 20)
    private String producer;

    @NotBlank(message = "Film türü boş olamaz")
    @Size(min = 2,max = 25,message = "Film türü '${validatevalue}' {min} ve {max} arasinda olmalı!")
    @Column(nullable = false, length = 25)
    private String genre;

}
