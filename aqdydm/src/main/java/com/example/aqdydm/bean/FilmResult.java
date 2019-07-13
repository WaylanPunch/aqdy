package com.example.aqdydm.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/13 1:11
 */
public class FilmResult {
    //状态码，成功200，失败400
    private int code;

    //错误和成功信息
    private String message;

    //包含的数据
    private Map<String, Object> data = new HashMap<>();

    //成功信息
    public static FilmResult success() {
        FilmResult filmResult = new FilmResult();
        filmResult.setCode(200);
        filmResult.setMessage("请求成功!");
        return filmResult;
    }

    //成功信息
    public static FilmResult failure() {
        FilmResult filmResult = new FilmResult();
        filmResult.setCode(400);
        filmResult.setMessage("请求失败!");
        return filmResult;
    }

    //添加包含的数据
    public FilmResult add(String key, Object value) {
        this.getData().put(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
