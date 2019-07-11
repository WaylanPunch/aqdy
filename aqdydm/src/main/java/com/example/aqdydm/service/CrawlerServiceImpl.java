package com.example.aqdydm.service;


import com.example.aqdydm.util.WebDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/7 22:19
 */
@Service(value = "crawlerService")
public class CrawlerServiceImpl //implements CrawlerService
{
    /*
    @Value(value = "${aqdydm.com.lunli}")
    private String lunli;
    @Value(value = "${aqdydm.com.lusi}")
    private String lusi;
    @Value(value = "${aqdydm.com.shebao}")
    private String shebao;
    @Value(value = "${aqdydm.com.lldm}")
    private String lldm;

    @Autowired
    MovieMapper movieMapper;

    @Override
    public int getLunLiData() {
        List<Movie> movies = WebDataUtil.getInstance().getData(lunli);
        return movies.size();
    }

    @Override
    public int getLuSiData() {
        List<Movie> movies = WebDataUtil.getInstance().getData(lusi);
        return movies.size();
    }

    @Override
    public int getSheBaoData() {
        boolean isDone = true;
        int index = 0;
        while (isDone) {
            ++index;
            String url = "";
            if (1 == index) {
                url = shebao + "/index.html";
            } else {
                url = shebao + "/index" + index + ".html";
            }
            List<Movie> movies = WebDataUtil.getInstance().getData(url);
            if (null == movies || movies.size() == 0) {
                isDone = false;
            } else {
                for (Movie movie : movies) {
                    MovieExample movieExample = new MovieExample();
                    MovieExample.Criteria criteria = movieExample.createCriteria();
                    criteria.andIdEqualTo(movie.getId());
                    long count = movieMapper.countByExample(movieExample);
                    if (count < 1) {
                        movieMapper.insertSelective(movie);
                    } else {
                        isDone = false;
                        break;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public int getLLDMData() {
        List<Movie> movies = WebDataUtil.getInstance().getData(lldm);
        return movies.size();
    }
    */
}
