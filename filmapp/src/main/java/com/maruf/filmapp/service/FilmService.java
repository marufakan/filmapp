package com.maruf.filmapp.service;

import com.maruf.filmapp.domain.Film;
import com.maruf.filmapp.dto.FilmDto;
import com.maruf.filmapp.exception.ResourceNotFoundException;
import com.maruf.filmapp.repository.FilmRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    // Get all films
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Create a new film
    public void createFilm(Film film) {
        filmRepository.save(film);
    }

    // Get a film
    public Film findFilm(Long id) {
        return filmRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Film not found. Id:"+id));
    }

    // Delete film
    public void deleteFilm(Long id) {
        Film film = findFilm(id);
        filmRepository.deleteById(id);
    }

    // Update film
    public void updateFilm(Long id, @Valid FilmDto filmDto) {
        Film film = findFilm(id);

        film.setFilmName(filmDto.getFilmName());
        film.setReleaseYear(filmDto.getReleaseYear());
        film.setImdbRating(filmDto.getImdbRating());
        film.setProducer(filmDto.getProducer());
        film.setGenre(filmDto.getGenre());

        filmRepository.save(film);

    }

}
