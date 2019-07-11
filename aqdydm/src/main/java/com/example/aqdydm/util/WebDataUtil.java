package com.example.aqdydm.util;

import com.example.aqdydm.bean.Movie;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/7 22:22
 */
public class WebDataUtil {
    //@Value(value = "${aqdydm.com}")
    //private String aqdydm = "http://aqdydm.com";
    private String aqdydmHTTPS = "https://aqdydm.com";
    private String aqdydmHTTP = "http://aqdydm.com";

    private static class WebDataUtilHolder {
        private static final WebDataUtil INSTANCE = new WebDataUtil();
    }

    private WebDataUtil() {
    }

    public static final WebDataUtil getInstance() {
        return WebDataUtilHolder.INSTANCE;
    }

    public List<Movie> getMainPageData(String url) {
        List<Movie> movies = new ArrayList<>();
        Connection connection = null;
        try {
            //这里是分享地址：
            ///String url  ="https://kg2.qq.com/node/play?s=571cI75H1xb495Eq&shareuid=609c9b812624338a&topsource=a0_pn201001006_z11_u21643941_l0_t1534223843__";
            connection = Jsoup.connect(url);
            //模拟浏览器的请求头
            connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            //开始连接HTTP请求。
            Connection.Response demo = connection.ignoreContentType(true).method(Connection.Method.GET).execute();
            Document documentDemo = demo.parse();
            //这里就是获取该页面的HTML元素。
            //System.out.println(documentDemo.toString());

            Element list = documentDemo.getElementById("contents");
            Elements items = list.getElementsByTag("li");
            for (Element item : items) {
                String link = item.getElementsByTag("a").get(0).attr("href");
                String id = link.split("/")[2];
                //link = aqdydm + link;
                String img = item.getElementsByTag("img").get(0).attr("src");
                String alt = item.getElementsByTag("img").get(0).attr("alt");
                String actor = item.getElementsByTag("p").get(0).html();
                actor = actor.substring(actor.lastIndexOf('>') + 1);
                String type = item.getElementsByTag("p").get(1).html();
                type = type.substring(type.lastIndexOf('>') + 1);
                String plot = item.getElementsByTag("p").get(2).html();
                plot = plot.substring(plot.lastIndexOf('>') + 1);
                String moreDesc = "";
                Movie movie = new Movie(id, link, img, alt, actor, type, plot, moreDesc, new Date());
                movie.setUpdated(new Date());
                movies.add(movie);
            }
        } catch (Exception e) {
            movies = null;
            e.printStackTrace();
        } finally {
            connection = null;
        }
        return movies;
    }

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Movie getDetailPageData(String url) {
        Movie movie = null;
        Connection connection = null;
        try {
            //这里是分享地址：
            //System.out.println("url = [" + aqdydm + url + "]");
            connection = Jsoup.connect(aqdydmHTTP + url);
            //模拟浏览器的请求头
            connection.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            //开始连接HTTP请求。
            Connection.Response demo = connection.ignoreContentType(true).method(Connection.Method.GET).execute();
            Document documentDemo = demo.parse();
            //这里就是获取该页面的HTML元素。
            //System.out.println(documentDemo.toString());

            movie = new Movie();
            Element detail = documentDemo.getElementsByClass("info fn-clear").get(0);
            Elements items = detail.getElementsByTag("dl");
            String status = items.get(1).getElementsByTag("dd").text();
            String region = items.get(3).getElementsByTag("dd").text();
            String language = items.get(4).getElementsByTag("dd").text();
            String director = items.get(5).getElementsByTag("dd").text();
            String createdStr = items.get(6).getElementsByTag("dd").text();

            movie.setStatus(status);
            movie.setRegion(region);
            movie.setLanguage(language);
            movie.setDirector(director);

            Date created = null;
            int year = 0;
            if (!StringUtils.isEmpty(createdStr)) {
                created = dateFormat.parse(createdStr);
                year = Integer.parseInt(createdStr.substring(0, 4));
            }

            if (0 != year) {
                movie.setYear(year);
            }
            if (null != created) {
                movie.setCreated(created);
            }
            try {
                Element play = documentDemo.getElementsByClass("play-list").get(0);
                Elements episodes = play.getElementsByTag("a");
                if (null != episodes && episodes.size() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Element episode : episodes) {
                        stringBuilder.append(episode.attr("href") + "#");
                    }
                    String playlist = stringBuilder.substring(0, stringBuilder.length() - 1).toString();
                    movie.setPlaylist(playlist);
                } else {
                    movie.setPlaylist("");
                }
            } catch (Exception e) {
                movie.setPlaylist("");
            }
        } catch (Exception e) {
            movie = null;
        } finally {
            connection = null;
        }
        return movie;
    }

    public Movie getDetailPageDataHTTPS(String link) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        try {
            url = new URL(aqdydmHTTPS + link);
            //url = new URL("https://www.baidu.com");
            HttpsURLConnection httpsConn = (HttpsURLConnection) url.openConnection();
            is = httpsConn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
            }
        }
        return null;
    }

    public Movie getDetailPageDataHTTP(String link) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;
        try {
            url = new URL(aqdydmHTTP + link);
            //url = new URL("http://www.baidu.com");
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException ioe) {
            }
        }
        return null;
    }
}
