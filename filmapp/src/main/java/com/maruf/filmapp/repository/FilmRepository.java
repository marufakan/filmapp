package com.maruf.filmapp.repository;

import com.maruf.filmapp.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
