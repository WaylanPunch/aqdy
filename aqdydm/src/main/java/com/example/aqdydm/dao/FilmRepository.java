package com.example.aqdydm.dao;

import com.example.aqdydm.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/13 13:05
 */
@Repository(value = "filmRepository")
public class FilmRepository implements IFilmRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Film> getFilmLunliListByPage(int pageIndex, int pageSize) {
        //System.out.println("pageIndex = [" + pageIndex + "], pageSize = [" + pageSize + "]");
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmLunli> filmLunlis = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmLunli.class, "filmLunli");

            if (null != filmLunlis && filmLunlis.size() > 0) {
                //System.out.println("Films Count = [" + filmLunlis.size() + "]");

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
    public List<Film> getFilmLusiListByPage(int pageIndex, int pageSize) {
        //System.out.println("pageIndex = [" + pageIndex + "], pageSize = [" + pageSize + "]");
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmLusi> filmLusis = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmLusi.class, "filmLusi");

            if (null != filmLusis && filmLusis.size() > 0) {
                //System.out.println("Films Count = [" + filmLusis.size() + "]");

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
    public List<Film> getFilmShebaoListByPage(int pageIndex, int pageSize) {
        //System.out.println("pageIndex = [" + pageIndex + "], pageSize = [" + pageSize + "]");
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmShebao> filmShebaos = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmShebao.class, "filmShebao");

            if (null != filmShebaos && filmShebaos.size() > 0) {
                //System.out.println("Films Count = [" + filmShebaos.size() + "]");

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
    public List<Film> getFilmLldmListByPage(int pageIndex, int pageSize) {
        //System.out.println("pageIndex = [" + pageIndex + "], pageSize = [" + pageSize + "]");
        List<Film> films = null;
        try {
            //查询小于当前时间的数据，并按时间倒序排列
            Sort sort = new Sort(Sort.Direction.DESC, "created");
            //分页查询（每页3行第2页）
            Pageable pageable = new PageRequest(pageIndex, pageSize, sort);
            List<FilmLldm> filmLldms = mongoTemplate.find(Query.query(Criteria.where("id").exists(true)).with(pageable), FilmLldm.class, "filmLldm");

            if (null != filmLldms && filmLldms.size() > 0) {
                //System.out.println("Films Count = [" + filmLldms.size() + "]");

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
    public Film getFilmLunliDetailById(String id) {
        Film film = null;
        try {
            FilmLunli filmLunli = mongoTemplate.findById(id, FilmLunli.class, "filmLunli");
            if (null != filmLunli) {
                film = new Film();
                film.setId(filmLunli.getId());
                film.setLink(filmLunli.getLink());
                film.setImg(filmLunli.getImg());
                film.setAlt(filmLunli.getAlt());
                film.setActor(filmLunli.getActor());
                film.setType(filmLunli.getType());
                film.setPlot(filmLunli.getPlot());
                film.setMoredesc(filmLunli.getMoredesc());
                film.setStatus(filmLunli.getStatus());
                film.setRegion(filmLunli.getRegion());
                film.setLanguage(filmLunli.getLanguage());
                film.setDirector(filmLunli.getDirector());
                film.setYear(filmLunli.getYear());
                film.setScore(filmLunli.getScore());
                film.setPlaylist(filmLunli.getPlaylist());
                film.setUpdated(filmLunli.getUpdated());
                film.setCreated(filmLunli.getCreated());
            }
        } catch (Exception e) {
            film = null;
        }
        return film;
    }

    @Override
    public Film getFilmLusiDetailById(String id) {
        Film film = null;
        try {
            FilmLusi filmLusi = mongoTemplate.findById(id, FilmLusi.class, "filmLusi");
            if (null != filmLusi) {
                film = new Film();
                film.setId(filmLusi.getId());
                film.setLink(filmLusi.getLink());
                film.setImg(filmLusi.getImg());
                film.setAlt(filmLusi.getAlt());
                film.setActor(filmLusi.getActor());
                film.setType(filmLusi.getType());
                film.setPlot(filmLusi.getPlot());
                film.setMoredesc(filmLusi.getMoredesc());
                film.setStatus(filmLusi.getStatus());
                film.setRegion(filmLusi.getRegion());
                film.setLanguage(filmLusi.getLanguage());
                film.setDirector(filmLusi.getDirector());
                film.setYear(filmLusi.getYear());
                film.setScore(filmLusi.getScore());
                film.setPlaylist(filmLusi.getPlaylist());
                film.setUpdated(filmLusi.getUpdated());
                film.setCreated(filmLusi.getCreated());
            }
        } catch (Exception e) {
            film = null;
        }
        return film;
    }

    @Override
    public Film getFilmShebaoDetailById(String id) {
        Film film = null;
        try {
            FilmShebao filmShebao = mongoTemplate.findById(id, FilmShebao.class, "filmShebao");
            if (null != filmShebao) {
                film = new Film();
                film.setId(filmShebao.getId());
                film.setLink(filmShebao.getLink());
                film.setImg(filmShebao.getImg());
                film.setAlt(filmShebao.getAlt());
                film.setActor(filmShebao.getActor());
                film.setType(filmShebao.getType());
                film.setPlot(filmShebao.getPlot());
                film.setMoredesc(filmShebao.getMoredesc());
                film.setStatus(filmShebao.getStatus());
                film.setRegion(filmShebao.getRegion());
                film.setLanguage(filmShebao.getLanguage());
                film.setDirector(filmShebao.getDirector());
                film.setYear(filmShebao.getYear());
                film.setScore(filmShebao.getScore());
                film.setPlaylist(filmShebao.getPlaylist());
                film.setUpdated(filmShebao.getUpdated());
                film.setCreated(filmShebao.getCreated());
            }
        } catch (Exception e) {
            film = null;
        }
        return film;
    }

    @Override
    public Film getFilmLldmDetailById(String id) {
        Film film = null;
        try {
            FilmLldm filmLldm = mongoTemplate.findById(id, FilmLldm.class, "filmLldm");
            if (null != filmLldm) {
                film = new Film();
                film.setId(filmLldm.getId());
                film.setLink(filmLldm.getLink());
                film.setImg(filmLldm.getImg());
                film.setAlt(filmLldm.getAlt());
                film.setActor(filmLldm.getActor());
                film.setType(filmLldm.getType());
                film.setPlot(filmLldm.getPlot());
                film.setMoredesc(filmLldm.getMoredesc());
                film.setStatus(filmLldm.getStatus());
                film.setRegion(filmLldm.getRegion());
                film.setLanguage(filmLldm.getLanguage());
                film.setDirector(filmLldm.getDirector());
                film.setYear(filmLldm.getYear());
                film.setScore(filmLldm.getScore());
                film.setPlaylist(filmLldm.getPlaylist());
                film.setUpdated(filmLldm.getUpdated());
                film.setCreated(filmLldm.getCreated());
            }
        } catch (Exception e) {
            film = null;
        }
        return film;
    }

    /*
    @Override
    public boolean update() {
        boolean result = false;
        try {

            int pageIndex = 0, pageSize = 100;
            boolean hasItems = true;
            while (hasItems) {
                Pageable pageable = new PageRequest(pageIndex, pageSize);
                List<FilmShebao> films = mongoTemplate.find(Query.query(Criteria.where("tags").exists(false)).with(pageable), FilmShebao.class, "filmShebao");
                if (null != films && films.size() > 0) {
                    System.out.println("Processing the " + (pageIndex + 1) + " page");
                    for (FilmShebao film : films) {
                        List<String> playList = new ArrayList<>();
                        List<String> plays = film.getPlaylist();
                        if (null != plays && plays.size() == 1) {
                            String[] playArray = plays.get(0).split("#");
                            for (String playStr : playArray) {
                                playList.add(playStr);
                            }
                        }

                        List<String> tags = new ArrayList<>();
                        tags.add("社保");
                        tags.add("电影");

                        Query query = new Query();
                        query.addCriteria(Criteria.where("_id").is(film.getId()));  //_id区分引号 "1"和1
                        Update update = new Update();
                        if (playList.size() != 0) {
                            update.set("playlist", playList);
                        }
                        update.set("tags", tags);
                        //	WriteResult upsert = mongoTemplate.updateMulti(query, update, "userList"); //查询到的全部更新
                        //	WriteResult upsert = mongoTemplate.updateFirst(query, update, "userList"); //查询更新第一条
                        mongoTemplate.upsert(query, update, "filmShebao");      //有则更新，没有则新增
                    }
                } else {
                    hasItems = false;
                }
                pageIndex++;
            }

            result = true;
        } catch (Exception e) {
            result = false;
            System.out.println("update() error : " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean check() {
        boolean result = false;
        try {

            int pageIndex = 0, pageSize = 100;
            boolean hasItems = true;
            while (hasItems) {
                Pageable pageable = new PageRequest(pageIndex, pageSize);
                List<FilmShebao> films = mongoTemplate.find(Query.query(Criteria.where("tags").exists(false)).with(pageable), FilmShebao.class, "filmShebao");
                if (null != films && films.size() > 0) {
                    System.out.println("Checking the " + (pageIndex + 1) + " page");
                    for (FilmShebao film : films) {
                        System.out.println("ID=" + film.getId());
                        System.out.println("PlayList=" + film.getPlaylist());
                    }
                } else {
                    hasItems = false;
                }
                pageIndex++;
            }

            result = true;
        } catch (Exception e) {
            result = false;
            System.out.println("check() error : " + e.getMessage());
        }
        return result;
    }
    */
}
