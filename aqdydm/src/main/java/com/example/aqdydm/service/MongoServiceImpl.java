package com.example.aqdydm.service;

import com.example.aqdydm.bean.*;
import com.example.aqdydm.dao.MovieLldmMapper;
import com.example.aqdydm.dao.MovieLunliMapper;
import com.example.aqdydm.dao.MovieLusiMapper;
import com.example.aqdydm.dao.MovieShebaoMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 * https://my.oschina.net/u/3452433/blog/2999501
 *
 * @author Waylan Punch
 * @date 2019/7/11 19:16
 */
@Service(value = "mongoService")
public class MongoServiceImpl implements MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MovieLunliMapper movieLunliMapper;
    @Autowired
    private MovieLusiMapper movieLusiMapper;
    @Autowired
    private MovieShebaoMapper movieShebaoMapper;
    @Autowired
    private MovieLldmMapper movieLldmMapper;

    @Override
    public boolean asynLunli() {
        boolean result = false;
        try {
            int pageIndex = 0;
            int pageSize = 100;
            boolean isDone = true;
            while (isDone) {
                MovieExample movieExample = new MovieExample();
                MovieExample.Criteria criteria = movieExample.createCriteria();
                criteria.andIdIsNotNull();
                RowBounds rowBounds = new RowBounds(pageIndex * pageSize, pageSize);
                List<Movie> movies = movieLunliMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
                if (null != movies && movies.size() > 0) {
                    System.out.println("Processing the " + (pageIndex + 1) + " page......");
                    for (Movie movie : movies) {
                        FilmLunli film = new FilmLunli();
                        film.setId(movie.getId());
                        film.setLink(movie.getLink());
                        film.setImg(movie.getImg());
                        film.setAlt(movie.getAlt());
                        film.setActor(movie.getActor());
                        film.setType(movie.getType());
                        film.setPlot(movie.getPlot());
                        film.setMoredesc(movie.getMoredesc());
                        film.setStatus(movie.getStatus());
                        film.setRegion(movie.getRegion());
                        film.setLanguage(movie.getLanguage());
                        film.setDirector(movie.getDirector());
                        film.setYear(movie.getYear());
                        film.setScore(movie.getScore());
                        film.setPlaylist(movie.getPlaylist());
                        film.setUpdated(movie.getUpdated());
                        film.setCreated(movie.getCreated());
                        mongoTemplate.insert(film);
                        movie = null;
                    }
                    movies = null;
                } else {
                    isDone = false;
                }
                pageIndex++;
            }
            result = true;
            System.out.println("Completed...... ");
        } catch (Exception e) {
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean asynLusi() {
        boolean result = false;
        try {
            int pageIndex = 0;
            int pageSize = 100;
            boolean isDone = true;
            while (isDone) {
                MovieExample movieExample = new MovieExample();
                MovieExample.Criteria criteria = movieExample.createCriteria();
                criteria.andIdIsNotNull();
                RowBounds rowBounds = new RowBounds(pageIndex * pageSize, pageSize);
                List<Movie> movies = movieLusiMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
                if (null != movies && movies.size() > 0) {
                    System.out.println("Processing the " + (pageIndex + 1) + " page......");
                    for (Movie movie : movies) {
                        FilmLusi film = new FilmLusi();
                        film.setId(movie.getId());
                        film.setLink(movie.getLink());
                        film.setImg(movie.getImg());
                        film.setAlt(movie.getAlt());
                        film.setActor(movie.getActor());
                        film.setType(movie.getType());
                        film.setPlot(movie.getPlot());
                        film.setMoredesc(movie.getMoredesc());
                        film.setStatus(movie.getStatus());
                        film.setRegion(movie.getRegion());
                        film.setLanguage(movie.getLanguage());
                        film.setDirector(movie.getDirector());
                        film.setYear(movie.getYear());
                        film.setScore(movie.getScore());
                        film.setPlaylist(movie.getPlaylist());
                        film.setUpdated(movie.getUpdated());
                        film.setCreated(movie.getCreated());
                        mongoTemplate.insert(film);
                        movie = null;
                    }
                    movies = null;
                } else {
                    isDone = false;
                }
                pageIndex++;
            }
            result = true;
            System.out.println("Completed...... ");
        } catch (Exception e) {
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean asynShebao() {
        boolean result = false;
        try {
            int pageIndex = 0;
            int pageSize = 100;
            boolean isDone = true;
            while (isDone) {
                MovieExample movieExample = new MovieExample();
                MovieExample.Criteria criteria = movieExample.createCriteria();
                criteria.andIdIsNotNull();
                RowBounds rowBounds = new RowBounds(pageIndex * pageSize, pageSize);
                List<Movie> movies = movieShebaoMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
                if (null != movies && movies.size() > 0) {
                    System.out.println("Processing the " + (pageIndex + 1) + " page......");
                    for (Movie movie : movies) {
                        FilmShebao film = new FilmShebao();
                        film.setId(movie.getId());
                        film.setLink(movie.getLink());
                        film.setImg(movie.getImg());
                        film.setAlt(movie.getAlt());
                        film.setActor(movie.getActor());
                        film.setType(movie.getType());
                        film.setPlot(movie.getPlot());
                        film.setMoredesc(movie.getMoredesc());
                        film.setStatus(movie.getStatus());
                        film.setRegion(movie.getRegion());
                        film.setLanguage(movie.getLanguage());
                        film.setDirector(movie.getDirector());
                        film.setYear(movie.getYear());
                        film.setScore(movie.getScore());
                        film.setPlaylist(movie.getPlaylist());
                        film.setUpdated(movie.getUpdated());
                        film.setCreated(movie.getCreated());
                        mongoTemplate.insert(film);
                        movie = null;
                    }
                    movies = null;
                } else {
                    isDone = false;
                }
                pageIndex++;
            }
            result = true;
            System.out.println("Completed...... ");
        } catch (Exception e) {
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public boolean asynLldm() {
        boolean result = false;
        try {
            int pageIndex = 0;
            int pageSize = 100;
            boolean isDone = true;
            while (isDone) {
                MovieExample movieExample = new MovieExample();
                MovieExample.Criteria criteria = movieExample.createCriteria();
                criteria.andIdIsNotNull();
                RowBounds rowBounds = new RowBounds(pageIndex * pageSize, pageSize);
                List<Movie> movies = movieLldmMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
                if (null != movies && movies.size() > 0) {
                    System.out.println("Processing the " + (pageIndex + 1) + " page......");
                    for (Movie movie : movies) {
                        FilmLldm film = new FilmLldm();
                        film.setId(movie.getId());
                        film.setLink(movie.getLink());
                        film.setImg(movie.getImg());
                        film.setAlt(movie.getAlt());
                        film.setActor(movie.getActor());
                        film.setType(movie.getType());
                        film.setPlot(movie.getPlot());
                        film.setMoredesc(movie.getMoredesc());
                        film.setStatus(movie.getStatus());
                        film.setRegion(movie.getRegion());
                        film.setLanguage(movie.getLanguage());
                        film.setDirector(movie.getDirector());
                        film.setYear(movie.getYear());
                        film.setScore(movie.getScore());
                        film.setPlaylist(movie.getPlaylist());
                        film.setUpdated(movie.getUpdated());
                        film.setCreated(movie.getCreated());
                        mongoTemplate.insert(film);
                        movie = null;
                    }
                    movies = null;
                } else {
                    isDone = false;
                }
                pageIndex++;
            }
            result = true;
            System.out.println("Completed...... ");
        } catch (Exception e) {
            result = false;
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Film> getFilmLunliByPage(int pageIndex, int pageSize) {
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmLunli> filmLunlis = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmLunli.class);

            if (null != filmLunlis && filmLunlis.size() > 0) {
                System.out.println("Films Count = [" + filmLunlis.size() + "]");

                films = new ArrayList<>();
                for (FilmLunli aFilm : filmLunlis) {
                    Film film = new Film();
                    film.setId(aFilm.getId());
                    film.setLink(aFilm.getLink());
                    film.setImg(aFilm.getImg());
                    film.setAlt(aFilm.getAlt());
                    film.setActor(aFilm.getActor());
                    film.setType(aFilm.getType());
                    film.setPlot(aFilm.getPlot());
                    film.setMoredesc(aFilm.getMoredesc());
                    film.setStatus(aFilm.getStatus());
                    film.setRegion(aFilm.getRegion());
                    film.setLanguage(aFilm.getLanguage());
                    film.setDirector(aFilm.getDirector());
                    film.setYear(aFilm.getYear());
                    film.setScore(aFilm.getScore());
                    film.setPlaylist(aFilm.getPlaylist());
                    film.setUpdated(aFilm.getUpdated());
                    film.setCreated(aFilm.getCreated());
                    films.add(film);
                }
            } else {
                System.out.println("Films Count = [NULL]");
            }
            //共多少条
            //Long count = mongoTemplate.count(Query.query(Criteria.where("parameter3").lt(new Date())), FilmLunli.class);
            //返回分页对象
            //Page<FilmLunli> page = new PageImpl<FilmLunli>(filmLunlis, pageable, filmLunlis.size());
        } catch (Exception e) {
            films = null;
        }
        return films;
    }

    @Override
    public List<Film> getFilmLusiByPage(int pageIndex, int pageSize) {
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmLusi> filmLusis = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmLusi.class);

            if (null != filmLusis && filmLusis.size() > 0) {
                System.out.println("Films Count = [" + filmLusis.size() + "]");

                films = new ArrayList<>();
                for (FilmLusi aFilm : filmLusis) {
                    Film film = new Film();
                    film.setId(aFilm.getId());
                    film.setLink(aFilm.getLink());
                    film.setImg(aFilm.getImg());
                    film.setAlt(aFilm.getAlt());
                    film.setActor(aFilm.getActor());
                    film.setType(aFilm.getType());
                    film.setPlot(aFilm.getPlot());
                    film.setMoredesc(aFilm.getMoredesc());
                    film.setStatus(aFilm.getStatus());
                    film.setRegion(aFilm.getRegion());
                    film.setLanguage(aFilm.getLanguage());
                    film.setDirector(aFilm.getDirector());
                    film.setYear(aFilm.getYear());
                    film.setScore(aFilm.getScore());
                    film.setPlaylist(aFilm.getPlaylist());
                    film.setUpdated(aFilm.getUpdated());
                    film.setCreated(aFilm.getCreated());
                    films.add(film);
                }
            } else {
                System.out.println("Films Count = [NULL]");
            }
            //共多少条
            //Long count = mongoTemplate.count(Query.query(Criteria.where("parameter3").lt(new Date())), FilmLunli.class);
            //返回分页对象
            //Page<FilmLunli> page = new PageImpl<FilmLunli>(filmLunlis, pageable, filmLunlis.size());
        } catch (Exception e) {
            films = null;
        }
        return films;
    }

    @Override
    public List<Film> getFilmShebaoByPage(int pageIndex, int pageSize) {
        System.out.println("pageIndex = [" + pageIndex + "], pageSize = [" + pageSize + "]");
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmShebao> filmShebaos = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmShebao.class, "filmShebao");

            if (null != filmShebaos && filmShebaos.size() > 0) {
                System.out.println("Films Count = [" + filmShebaos.size() + "]");

                films = new ArrayList<>();
                for (FilmShebao aFilm : filmShebaos) {
                    //System.out.println("Film Link = [" + aFilm.getLink() + "]");
                    Film film = new Film();
                    film.setId(aFilm.getId());
                    film.setLink(aFilm.getLink());
                    film.setImg(aFilm.getImg());
                    film.setAlt(aFilm.getAlt());
                    film.setActor(aFilm.getActor());
                    film.setType(aFilm.getType());
                    film.setPlot(aFilm.getPlot());
                    film.setMoredesc(aFilm.getMoredesc());
                    film.setStatus(aFilm.getStatus());
                    film.setRegion(aFilm.getRegion());
                    film.setLanguage(aFilm.getLanguage());
                    film.setDirector(aFilm.getDirector());
                    film.setYear(aFilm.getYear());
                    film.setScore(aFilm.getScore());
                    film.setPlaylist(aFilm.getPlaylist());
                    film.setUpdated(aFilm.getUpdated());
                    film.setCreated(aFilm.getCreated());
                    films.add(film);
                }
            } else {
                System.out.println("Films Count = [NULL]");
            }
            //共多少条
            //Long count = mongoTemplate.count(Query.query(Criteria.where("parameter3").lt(new Date())), FilmLunli.class);
            //返回分页对象
            //Page<FilmLunli> page = new PageImpl<FilmLunli>(filmLunlis, pageable, filmLunlis.size());
        } catch (Exception e) {
            films = null;
        }
        return films;
    }

    @Override
    public List<Film> getFilmLldmByPage(int pageIndex, int pageSize) {
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmLldm> filmLldms = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmLldm.class);

            if (null != filmLldms && filmLldms.size() > 0) {
                System.out.println("Films Count = [" + filmLldms.size() + "]");

                films = new ArrayList<>();
                for (FilmLldm aFilm : filmLldms) {
                    Film film = new Film();
                    film.setId(aFilm.getId());
                    film.setLink(aFilm.getLink());
                    film.setImg(aFilm.getImg());
                    film.setAlt(aFilm.getAlt());
                    film.setActor(aFilm.getActor());
                    film.setType(aFilm.getType());
                    film.setPlot(aFilm.getPlot());
                    film.setMoredesc(aFilm.getMoredesc());
                    film.setStatus(aFilm.getStatus());
                    film.setRegion(aFilm.getRegion());
                    film.setLanguage(aFilm.getLanguage());
                    film.setDirector(aFilm.getDirector());
                    film.setYear(aFilm.getYear());
                    film.setScore(aFilm.getScore());
                    film.setPlaylist(aFilm.getPlaylist());
                    film.setUpdated(aFilm.getUpdated());
                    film.setCreated(aFilm.getCreated());
                    films.add(film);
                }
            } else {
                System.out.println("Films Count = [NULL]");
            }
            //共多少条
            //Long count = mongoTemplate.count(Query.query(Criteria.where("parameter3").lt(new Date())), FilmLunli.class);
            //返回分页对象
            //Page<FilmLunli> page = new PageImpl<FilmLunli>(filmLunlis, pageable, filmLunlis.size());
        } catch (Exception e) {
            films = null;
        }
        return films;
    }

}
