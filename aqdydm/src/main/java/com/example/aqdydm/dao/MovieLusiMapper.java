package com.example.aqdydm.dao;

import com.example.aqdydm.bean.Movie;
import com.example.aqdydm.bean.MovieExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
@Mapper
public interface MovieLusiMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    long countByExample(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    int deleteByExample(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    int insert(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    int insertSelective(Movie record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    List<Movie> selectByExampleWithRowbounds(MovieExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    List<Movie> selectByExample(MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_lusi
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);
}