package com.example.aqdydm.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * A New Class Created By Waylan Punch
 * https://github.com/WaylanPunch
 *
 * @author Waylan Punch
 * @date 2019/7/11 1:08
 */
//注释此类将被映射到数据库的一个集合（collection为集合名称）
@Document(collection = "filmShebao")

//创建联合索引
@CompoundIndexes({
        //联合索引 name 索引名称 、def 索引字段、parameter1升序、parameter3降序
        @CompoundIndex(name = "compound_index", def = "{'actor': 1, 'type': -1}")
})
public class FilmShebao implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.id
     *
     * @mbg.generated
     */
    //标记id字段
    @Id
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.link
     *
     * @mbg.generated
     */
    private String link;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.img
     *
     * @mbg.generated
     */
    private String img;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.alt
     *
     * @mbg.generated
     */
    private String alt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.actor
     *
     * @mbg.generated
     */
    private String actor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.type
     *
     * @mbg.generated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.plot
     *
     * @mbg.generated
     */
    private String plot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.moreDesc
     *
     * @mbg.generated
     */
    private String moredesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.region
     *
     * @mbg.generated
     */
    private String region;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.language
     *
     * @mbg.generated
     */
    private String language;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.director
     *
     * @mbg.generated
     */
    private String director;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.year
     *
     * @mbg.generated
     */
    //创建单字段索引（默认ASCENDING 升序、DESCENDING 降序）
    @Indexed(direction = DESCENDING)
    private Integer year;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.score
     *
     * @mbg.generated
     */
    private String score;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.playList
     *
     * @mbg.generated
     */
    private List<String> playlist;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.updated
     *
     * @mbg.generated
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_lldm.created
     *
     * @mbg.generated
     */
    private Date created;
    private List<String> tags;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie_lldm
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lldm
     *
     * @mbg.generated
     */
    public FilmShebao() {
        super();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.id
     *
     * @return the value of movie_lldm.id
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.id
     *
     * @param id the value for movie_lldm.id
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.link
     *
     * @return the value of movie_lldm.link
     * @mbg.generated
     */
    public String getLink() {
        return link;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.link
     *
     * @param link the value for movie_lldm.link
     * @mbg.generated
     */
    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.img
     *
     * @return the value of movie_lldm.img
     * @mbg.generated
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.img
     *
     * @param img the value for movie_lldm.img
     * @mbg.generated
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.alt
     *
     * @return the value of movie_lldm.alt
     * @mbg.generated
     */
    public String getAlt() {
        return alt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.alt
     *
     * @param alt the value for movie_lldm.alt
     * @mbg.generated
     */
    public void setAlt(String alt) {
        this.alt = alt == null ? null : alt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.actor
     *
     * @return the value of movie_lldm.actor
     * @mbg.generated
     */
    public String getActor() {
        return actor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.actor
     *
     * @param actor the value for movie_lldm.actor
     * @mbg.generated
     */
    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.type
     *
     * @return the value of movie_lldm.type
     * @mbg.generated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.type
     *
     * @param type the value for movie_lldm.type
     * @mbg.generated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.plot
     *
     * @return the value of movie_lldm.plot
     * @mbg.generated
     */
    public String getPlot() {
        return plot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.plot
     *
     * @param plot the value for movie_lldm.plot
     * @mbg.generated
     */
    public void setPlot(String plot) {
        this.plot = plot == null ? null : plot.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.moreDesc
     *
     * @return the value of movie_lldm.moreDesc
     * @mbg.generated
     */
    public String getMoredesc() {
        return moredesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.moreDesc
     *
     * @param moredesc the value for movie_lldm.moreDesc
     * @mbg.generated
     */
    public void setMoredesc(String moredesc) {
        this.moredesc = moredesc == null ? null : moredesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.status
     *
     * @return the value of movie_lldm.status
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.status
     *
     * @param status the value for movie_lldm.status
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.region
     *
     * @return the value of movie_lldm.region
     * @mbg.generated
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.region
     *
     * @param region the value for movie_lldm.region
     * @mbg.generated
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.language
     *
     * @return the value of movie_lldm.language
     * @mbg.generated
     */
    public String getLanguage() {
        return language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.language
     *
     * @param language the value for movie_lldm.language
     * @mbg.generated
     */
    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.director
     *
     * @return the value of movie_lldm.director
     * @mbg.generated
     */
    public String getDirector() {
        return director;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.director
     *
     * @param director the value for movie_lldm.director
     * @mbg.generated
     */
    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.year
     *
     * @return the value of movie_lldm.year
     * @mbg.generated
     */
    public Integer getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.year
     *
     * @param year the value for movie_lldm.year
     * @mbg.generated
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.score
     *
     * @return the value of movie_lldm.score
     * @mbg.generated
     */
    public String getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.score
     *
     * @param score the value for movie_lldm.score
     * @mbg.generated
     */
    public void setScore(String score) {
        this.score = score == null ? null : score.trim();
    }

    public List<String> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<String> playlist) {
        this.playlist = playlist;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.updated
     *
     * @return the value of movie_lldm.updated
     * @mbg.generated
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.updated
     *
     * @param updated the value for movie_lldm.updated
     * @mbg.generated
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_lldm.created
     *
     * @return the value of movie_lldm.created
     * @mbg.generated
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_lldm.created
     *
     * @param created the value for movie_lldm.created
     * @mbg.generated
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
