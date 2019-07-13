package com.example.aqdydm.controller;

import com.example.aqdydm.bean.Film;
import com.example.aqdydm.bean.FilmResult;
import com.example.aqdydm.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/7 22:15
 */
@Controller
public class HomeController {

    @Autowired
    private FilmService filmService;

    @GetMapping(value = {"/", "/index", "/home"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/film/page/{type}/{pageIndex}")
    @ResponseBody
    public FilmResult load(@PathVariable(name = "type") int type, @PathVariable(name = "pageIndex") int pageIndex) {
        List<Film> films = filmService.getFilmListByPage(type, pageIndex, 12);
        if (null != films) {
            return FilmResult.success().add("films", films);
        } else {
            return FilmResult.failure();
        }
    }

    @GetMapping(value = "/film/detail/{type}/{id}")
    public String filmDetail(@PathVariable(name = "type") int type, @PathVariable(name = "id") String id, Model model) {
        Film film = filmService.getFilmDetailById(type, id);
        model.addAttribute("film", film);
        return "filmDetail";
    }

    @GetMapping(value = "/actor/japan")
    public String actor1() {
        return "actor";
    }

    @GetMapping(value = "/actor/other")
    public String actor2() {
        return "actor";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact";
    }
}
