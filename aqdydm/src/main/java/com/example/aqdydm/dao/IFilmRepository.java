package com.example.aqdydm.dao;

import com.example.aqdydm.bean.Film;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/13 13:04
 */
public interface IFilmRepository {
    public List<Film> getFilmLunliListByPage(int pageIndex, int pageSize);

    public List<Film> getFilmLusiListByPage(int pageIndex, int pageSize);

    public List<Film> getFilmShebaoListByPage(int pageIndex, int pageSize);

    public List<Film> getFilmLldmListByPage(int pageIndex, int pageSize);

    public Film getFilmLunliDetailById(String id);

    public Film getFilmLusiDetailById(String id);

    public Film getFilmShebaoDetailById(String id);

    public Film getFilmLldmDetailById(String id);

    /*public boolean update();

    public boolean check();*/
}
