package com.example.aqdydm.service;

import com.example.aqdydm.bean.Film;

import java.util.List;

public interface FilmService {
    public List<Film> getFilmListByPage(int type, int pageIndex, int pageSize);

    public Film getFilmDetailById(int type, String id);
}
