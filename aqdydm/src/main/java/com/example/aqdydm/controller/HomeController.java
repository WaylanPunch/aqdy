package com.example.aqdydm.controller;

import com.example.aqdydm.bean.Film;
import com.example.aqdydm.service.CrawlerService;
import com.example.aqdydm.service.MongoService;
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
    private MongoService mongoService;

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Film> films = mongoService.getFilmShebaoByPage(0, 12);
        model.addAttribute("films", films);
        model.addAttribute("pageIndex", 0);
        model.addAttribute("pageSize", 12);
        return "index";
    }

    @GetMapping(value = "/index")
    public String index2(Model model) {
        List<Film> films = mongoService.getFilmShebaoByPage(0, 12);
        model.addAttribute("films", films);
        model.addAttribute("pageIndex", 0);
        model.addAttribute("pageSize", 12);
        return "index";
    }

    @GetMapping(value = "/loadmore/{pageIndex}")
    public String loadMore(@PathVariable(name = "pageIndex") int pageIndex, Model model) {
        List<Film> films = mongoService.getFilmShebaoByPage(pageIndex, 12);
        model.addAttribute("films", films);
        model.addAttribute("pageIndex", pageIndex);
        model.addAttribute("pageSize", 12);
        return "index";
    }

    @GetMapping(value = "/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping(value = "/blogsingle")
    public String blogSingle() {
        return "blog-single";
    }

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact";
    }
}
