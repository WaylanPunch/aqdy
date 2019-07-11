package com.example.aqdydm;


import com.example.aqdydm.bean.FilmLunli;
import com.example.aqdydm.bean.Movie;
import com.example.aqdydm.bean.MovieExample;
import com.example.aqdydm.dao.MovieLldmMapper;
import com.example.aqdydm.dao.MovieLunliMapper;
import com.example.aqdydm.dao.MovieLusiMapper;
import com.example.aqdydm.dao.MovieShebaoMapper;
import com.example.aqdydm.util.WebDataUtil;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AqdydmApplicationTests {

    @Test
    public void contextLoads() {
        /*
        String str1 = "/shebao/AMA042SEXyicaizhenmujinriziyiersanlingsiyongzhuqibing/";
        String[] arr1 = str1.split("/");
        for (int i = 0; i < arr1.length; i++)
            System.out.println("==" + arr1[i]);
        */

        /*
        String str2 = "";//"<em>主演:</em>真木今日子 一二三铃 嗣永さゆみ 渚みつき";
        str2 = str2.substring(str2.lastIndexOf('>') + 1);
        System.out.println("==" + str2);
        */

        /*
        String str1 = "AMA042SEXyicaizhenmujinriziyiersanlingsiyongzhuqibing";
        System.out.println("==" + str1.hashCode() % 2);
        */

        /*
        String url = "http://aqdydm.com/lunli/index2349.html";
        List<Movie> movies = WebDataUtil.getInstance().getMainPageData(url);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
        */

        /*
        Movie movie = WebDataUtil.getInstance().getDetailPageData("/lunli/zhengtongpaichaomeinvchangzeziqibing/");
        System.out.println(movie);
        */

        WebDataUtil.getInstance().getDetailPageDataHTTPS("/lunli/zhengtongpaichaomeinvchangzeziqibing/");


        /*
        String link = "http://aqdydm.com/lusi/010116060nvredalumashengxibubing/";
        link = link.substring(17, link.length() - 1);
        System.out.println(link);
        */
    }

    @Test
    public void generatorMyBatis() {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            File configFile = new File("src/main/resources/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (XMLParserException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    private MovieLunliMapper movieLunliMapper;
    @Autowired
    private MovieLusiMapper movieLusiMapper;
    @Autowired
    private MovieShebaoMapper movieShebaoMapper;
    @Autowired
    private MovieLldmMapper movieLldmMapper;

    @Test
    public void testMyBatis() {

        Movie movie1 = new Movie("1", "sdfsdf", "sdfsdfer", "rerty", "ertert", "45645y", "456456", "dfgrty", new Date());
        movieLunliMapper.insertSelective(movie1);
        movieLusiMapper.insertSelective(movie1);
        movieShebaoMapper.insertSelective(movie1);
        movieLldmMapper.insertSelective(movie1);

        String id = "";
        MovieExample movieExample = new MovieExample();
        MovieExample.Criteria criteria = movieExample.createCriteria();
        //criteria.andIdEqualTo(id);
        criteria.andIdIsNotNull();
        List<Movie> movies1 = movieLunliMapper.selectByExample(movieExample);
        if (null != movies1 && movies1.size() > 0) {
            for (Movie movie : movies1) {
                System.out.println(movie.toString());
            }
        } else {
            System.out.println("no data at all");
        }
        List<Movie> movies2 = movieLusiMapper.selectByExample(movieExample);
        if (null != movies2 && movies2.size() > 0) {
            for (Movie movie : movies2) {
                System.out.println(movie.toString());
            }
        } else {
            System.out.println("no data at all");
        }
        List<Movie> movies3 = movieShebaoMapper.selectByExample(movieExample);
        if (null != movies3 && movies3.size() > 0) {
            for (Movie movie : movies3) {
                System.out.println(movie.toString());
            }
        } else {
            System.out.println("no data at all");
        }
        List<Movie> movies4 = movieLldmMapper.selectByExample(movieExample);
        if (null != movies4 && movies4.size() > 0) {
            for (Movie movie : movies4) {
                System.out.println(movie.toString());
            }
        } else {
            System.out.println("no data at all");
        }
    }

    @Test
    public void initDatabaseForLunli() {
        String shebao = "http://aqdydm.com/lunli";

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
            System.out.println("Processing " + url + "");

            List<Movie> movies = WebDataUtil.getInstance().getMainPageData(url);
            if (null == movies || movies.size() == 0) {
                isDone = false;
            } else {
                System.out.println("Processing " + movies.size() + " items......");
                for (Movie movie : movies) {

                    try {
                        movieLunliMapper.insertSelective(movie);
                    } catch (Exception e) {
                        continue;
                    }


                    /*
                    MovieExample movieExample = new MovieExample();
                    MovieExample.Criteria criteria = movieExample.createCriteria();
                    criteria.andIdEqualTo(movie.getId());
                    long count = movieLunliMapper.countByExample(movieExample);
                    if (count < 1) {
                        movieLunliMapper.insertSelective(movie);
                    }
                    */
                }
            }
        }
    }

    @Test
    public void initDatabaseForLusi() {
        String shebao = "http://aqdydm.com/lusi";

        boolean isDone = true;
        int index = 2326;
        while (isDone) {
            ++index;
            String url = "";
            if (1 == index) {
                url = shebao + "/index.html";
            } else {
                url = shebao + "/index" + index + ".html";
            }
            System.out.println("Processing " + url + "");

            List<Movie> movies = WebDataUtil.getInstance().getMainPageData(url);
            if (null == movies || movies.size() == 0) {
                isDone = false;
            } else {
                System.out.println("Processing " + movies.size() + " items......");
                for (Movie movie : movies) {

                    try {
                        movieLusiMapper.insertSelective(movie);
                    } catch (Exception e) {
                        continue;
                    }

                    /*
                    MovieExample movieExample = new MovieExample();
                    MovieExample.Criteria criteria = movieExample.createCriteria();
                    criteria.andIdEqualTo(movie.getId());
                    long count = movieLusiMapper.countByExample(movieExample);
                    if (count < 1) {
                        movieLusiMapper.insertSelective(movie);
                    }
                    */
                }
            }
        }
    }

    @Test
    public void initDatabaseForShebao() {
        String shebao = "http://aqdydm.com/shebao";

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
            System.out.println("Processing the " + index + " page......");

            List<Movie> movies = WebDataUtil.getInstance().getMainPageData(url);
            if (null == movies || movies.size() == 0) {
                isDone = false;
            } else {
                for (Movie movie : movies) {
                    try {
                        movieShebaoMapper.insertSelective(movie);
                    } catch (Exception e) {
                        continue;
                    }
                    /*
                    MovieExample movieExample = new MovieExample();
                    MovieExample.Criteria criteria = movieExample.createCriteria();
                    criteria.andIdEqualTo(movie.getId());
                    long count = movieShebaoMapper.countByExample(movieExample);
                    if (count < 1) {
                        movieShebaoMapper.insertSelective(movie);
                    }
                    */
                }
            }
        }
    }

    @Test
    public void initDatabaseForLldm() {
        //String shebao = "http://aqdydm.com/lunli";
        //String shebao = "http://aqdydm.com/lusi";
        //String shebao = "http://aqdydm.com/shebao";
        String shebao = "http://aqdydm.com/lldm";

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
            System.out.println("Processing the " + index + " page......");

            List<Movie> movies = WebDataUtil.getInstance().getMainPageData(url);
            if (null == movies || movies.size() == 0) {
                isDone = false;
            } else {
                for (Movie movie : movies) {
                    try {
                        movieLldmMapper.insertSelective(movie);
                    } catch (Exception e) {
                        continue;
                    }
                    /*
                    MovieExample movieExample = new MovieExample();
                    MovieExample.Criteria criteria = movieExample.createCriteria();
                    criteria.andIdEqualTo(movie.getId());
                    long count = movieLldmMapper.countByExample(movieExample);
                    if (count < 1) {
                        movieLldmMapper.insertSelective(movie);
                    }
                    */
                }
            }
        }
    }

    @Test
    public void initDatabaseForLunliDetail() {

        int pageIndex = 0;
        boolean isDone = true;
        while (isDone) {
            pageIndex++;
            MovieExample movieExample = new MovieExample();
            MovieExample.Criteria criteria = movieExample.createCriteria();
            criteria.andPlaylistIsNull();
            RowBounds rowBounds = new RowBounds(0, 10);
            List<Movie> movies = movieLunliMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
            if (null != movies && movies.size() > 0) {
                System.out.println("Processing the " + pageIndex + " page......");
                for (Movie movie : movies) {
                    //System.out.println("Movie Id = " + movie.getId());
                    Movie movie1 = WebDataUtil.getInstance().getDetailPageData(movie.getLink());
                    if (null != movie1) {
                        MovieExample movieExample1 = new MovieExample();
                        MovieExample.Criteria criteria1 = movieExample1.createCriteria();
                        criteria1.andIdEqualTo(movie.getId());
                        movieLunliMapper.updateByExampleSelective(movie1, movieExample1);
                    }
                    movie = null;
                    movie1 = null;
                }
                movies = null;
            } else {
                isDone = false;
            }
            rowBounds = null;
            criteria = null;
            movieExample = null;
        }
        System.out.println("Completed...... ");
    }

    @Test
    public void initDatabaseForLusiDetail() {

        int pageIndex = 0;
        boolean isDone = true;
        while (isDone) {
            pageIndex++;
            MovieExample movieExample = new MovieExample();
            MovieExample.Criteria criteria = movieExample.createCriteria();
            criteria.andPlaylistIsNull();
            RowBounds rowBounds = new RowBounds(0, 10);
            List<Movie> movies = movieLusiMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
            if (null != movies && movies.size() > 0) {
                System.out.println("Processing the " + pageIndex + " page......");
                for (Movie movie : movies) {
                    Movie movie1 = WebDataUtil.getInstance().getDetailPageData(movie.getLink());
                    if (null != movie1) {
                        System.out.println("Movie PlayList = " + movie1.getPlaylist());
                        MovieExample movieExample1 = new MovieExample();
                        MovieExample.Criteria criteria1 = movieExample1.createCriteria();
                        criteria1.andIdEqualTo(movie.getId());
                        movieLusiMapper.updateByExampleSelective(movie1, movieExample1);
                    }
                    movie = null;
                    movie1 = null;
                }
                movies = null;
            } else {
                isDone = false;
            }
            rowBounds = null;
            criteria = null;
            movieExample = null;
        }
        System.out.println("Completed...... ");
    }

    @Test
    public void initDatabaseForShebaoDetail() {

        int pageIndex = 0;
        boolean isDone = true;
        while (isDone) {
            pageIndex++;
            MovieExample movieExample = new MovieExample();
            MovieExample.Criteria criteria = movieExample.createCriteria();
            criteria.andPlaylistIsNull();
            RowBounds rowBounds = new RowBounds(0, 20);
            List<Movie> movies = movieShebaoMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
            if (null != movies && movies.size() > 0) {
                System.out.println("Processing the " + pageIndex + " page......");
                for (Movie movie : movies) {
                    //System.out.println("Movie Id = " + movie.getId());
                    Movie movie1 = WebDataUtil.getInstance().getDetailPageData(movie.getLink());
                    if (null != movie1) {
                        MovieExample movieExample1 = new MovieExample();
                        MovieExample.Criteria criteria1 = movieExample1.createCriteria();
                        criteria1.andIdEqualTo(movie.getId());
                        movieShebaoMapper.updateByExampleSelective(movie1, movieExample1);
                    }
                    movie = null;
                    movie1 = null;
                }
                movies = null;
            } else {
                isDone = false;
            }
            rowBounds = null;
            criteria = null;
            movieExample = null;
        }
        System.out.println("Completed...... ");
    }

    @Test
    public void initDatabaseForLldmDetail() {

        int pageIndex = 0;
        boolean isDone = true;
        while (isDone) {
            pageIndex++;
            MovieExample movieExample = new MovieExample();
            MovieExample.Criteria criteria = movieExample.createCriteria();
            criteria.andPlaylistIsNull();
            RowBounds rowBounds = new RowBounds(0, 10);
            List<Movie> movies = movieLldmMapper.selectByExampleWithRowbounds(movieExample, rowBounds);
            if (null != movies && movies.size() > 0) {
                System.out.println("Processing the " + pageIndex + " page......");
                for (Movie movie : movies) {
                    //System.out.println("Movie Id = " + movie.getId());
                    Movie movie1 = WebDataUtil.getInstance().getDetailPageData(movie.getLink());
                    if (null != movie1) {
                        MovieExample movieExample1 = new MovieExample();
                        MovieExample.Criteria criteria1 = movieExample1.createCriteria();
                        criteria1.andIdEqualTo(movie.getId());
                        movieLldmMapper.updateByExampleSelective(movie1, movieExample1);
                    }
                    movie = null;
                    movie1 = null;
                }
                movies = null;
            } else {
                isDone = false;
            }
            rowBounds = null;
            criteria = null;
            movieExample = null;
        }
        System.out.println("Completed...... ");
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void importMySQLToMongoDB() {
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
        System.out.println("Completed...... ");
    }

}
