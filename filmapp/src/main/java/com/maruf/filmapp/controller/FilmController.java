package com.maruf.filmapp.controller;

import com.maruf.filmapp.domain.Film;
import com.maruf.filmapp.dto.FilmDto;
import com.maruf.filmapp.service.FilmService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    // Get all films
    @GetMapping//films + GET
    public ResponseEntity<List<Film>> listAllFilms(){
        List<Film> filmList = filmService.getAllFilms();
        return ResponseEntity.ok(filmList);
    }
    // Create a new film
    @PostMapping//films + POST + JSON
    public ResponseEntity<Map<String,String>> createFilm(@Valid @RequestBody Film film){
        filmService.createFilm(film);
        Map<String,String> response = new HashMap<>();
        response.put("message","Film created successfully");
        response.put("status","200");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Get a film
    @GetMapping("/{id}")//films/1 + GET
    public ResponseEntity<Film> getFilmById(@PathVariable("id") Long id){
        return new ResponseEntity<>(filmService.findFilm(  id),HttpStatus.OK);
    }
    // Delete film
    @DeleteMapping("/{id}")//films/1 + DELETE
    public ResponseEntity<Map<String,String>> deleteFilm(@PathVariable("id") Long id){
        filmService.deleteFilm(id);
        Map<String,String> response = new HashMap<>();
        response.put("message","Film deleted successfully");
        response.put("status","200");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    // Update film
    @DeleteMapping("/{id}")//films/1 + PUT + JSON
    public  ResponseEntity<Map<String,String>> updateFilm(@PathVariable("id") Long id, @Valid @RequestBody FilmDto filmDto){
        filmService.updateFilm(id, filmDto);
        Map<String,String> response = new HashMap<>();
        response.put("message","Film updated successfully");
        response.put("status","200");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
