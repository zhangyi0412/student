package com.test.student.service;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.Score;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
public interface ScoreService {
    /**
     * 分页查询用户
     * @param score
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Score> listScores(Score score, int page, int limit);

    /**
     * 禁用用户
     * @param score
     * @return
     */
    boolean deleteScore(Score score);

    boolean activeScore(Score score);

    boolean deleteScores(List<Score> scores);

    boolean updateScore(Score score);

    boolean insertScore(Score score);
}
