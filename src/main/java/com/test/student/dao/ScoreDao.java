package com.test.student.dao;

import com.test.student.pojo.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Mapper
public interface ScoreDao {
    /**
     * 查询用户
     * @param score
     * @return
     */
    public List<Score> listScores(Score score);

    /**
     * 禁用用户
     * @param score
     * @return
     */
    int deleteScore(Score score);

    int activeScore(Score score);

    boolean updateScore(Score score);

    boolean insertScore(Score score);
}
