package com.example.aqdydm.controller;

import com.example.aqdydm.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/11 19:10
 */
@Controller
@RequestMapping(value = "/mongo")
public class MongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping(value = "/asyn/lunli")
    @ResponseBody
    public String asynLunli() {
        boolean result = mongoService.asynLunli();
        if (result) {
            return "ok";
        }
        else {
            return "not ok";
        }
    }
    @GetMapping(value = "/asyn/lusi")
    @ResponseBody
    public String asynLusi() {
        boolean result = mongoService.asynLusi();
        if (result) {
            return "ok";
        }
        else {
            return "not ok";
        }
    }
    @GetMapping(value = "/asyn/shebao")
    @ResponseBody
    public String asynShebao() {
        boolean result = mongoService.asynShebao();
        if (result) {
            return "ok";
        }
        else {
            return "not ok";
        }
    }
    @GetMapping(value = "/asyn/lldm")
    @ResponseBody
    public String asynLldm() {
        boolean result = mongoService.asynLldm();
        if (result) {
            return "ok";
        }
        else {
            return "not ok";
        }
    }
}
