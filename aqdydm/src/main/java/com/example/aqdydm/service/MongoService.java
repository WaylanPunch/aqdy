package com.example.aqdydm.service;

import com.example.aqdydm.bean.Film;

import java.util.List;

public interface MongoService {

    public boolean asynLunli();

    public boolean asynLusi();

    public boolean asynShebao();

    public boolean asynLldm();

    public List<Film> getFilmLunliByPage(int pageIndex, int pageSize);

    public List<Film> getFilmLusiByPage(int pageIndex, int pageSize);

    public List<Film> getFilmShebaoByPage(int pageIndex, int pageSize);

    public List<Film> getFilmLldmByPage(int pageIndex, int pageSize);
}
