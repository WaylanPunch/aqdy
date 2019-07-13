package com.example.aqdydm.service;

import com.example.aqdydm.bean.*;
import com.example.aqdydm.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 * https://my.oschina.net/u/3452433/blog/2999501
 *
 * @author Waylan Punch
 * @date 2019/7/11 19:16
 */
@Service(value = "filmService")
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDao filmDao;

    @Override
    public List<Film> getFilmListByPage(int type, int pageIndex, int pageSize) {
        System.out.println("type = [" + type + "], pageIndex = [" + pageIndex + "], pageSize = [" + pageSize + "]");
        List<Film> films = null;
        if (0 == type) {
            films = filmDao.getFilmLunliListByPage(pageIndex, pageSize);
        } else if (1 == type) {
            films = filmDao.getFilmLusiListByPage(pageIndex, pageSize);
        } else if (2 == type) {
            films = filmDao.getFilmShebaoListByPage(pageIndex, pageSize);
        } else if (3 == type) {
            films = filmDao.getFilmLldmListByPage(pageIndex, pageSize);
        } else {
            films = filmDao.getFilmShebaoListByPage(pageIndex, pageSize);
        }
        System.out.println("Films Count = [" + films.size() + "]");
        return films;
    }

    @Override
    public Film getFilmDetailById(int type, String id) {
        System.out.println("type = [" + type + "], id = [" + id + "]");
        Film film = null;
        if (0 == type) {
            film = filmDao.getFilmLunliDetailById(id);
        }
        if (1 == type) {
            film = filmDao.getFilmLusiDetailById(id);
        }
        if (2 == type) {
            film = filmDao.getFilmShebaoDetailById(id);
        }
        if (3 == type) {
            film = filmDao.getFilmLldmDetailById(id);
        }
        System.out.println("Film = [" + film.getId() + "]");
        return film;
    }
}
