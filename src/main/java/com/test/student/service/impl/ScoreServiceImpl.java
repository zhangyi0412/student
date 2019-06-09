package com.test.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.student.dao.ScoreDao;
import com.test.student.pojo.Score;
import com.test.student.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Resource
    ScoreDao scoreDao;

    @Override
    public PageInfo<Score> listScores(Score score, int page, int limit) {
        //开启分页查询，写在查询语句上方
        PageHelper.startPage(page, limit);
        // 查询所有的用户
        List<Score> scores = scoreDao.listScores(score);
        // 注意这里的泛型
        PageInfo<Score> pageInfo = new PageInfo<>(scores);
        // 返回分页信息
        return pageInfo;
    }

    @Override
    public boolean deleteScore(Score score) {
        int count = 0;
        count = scoreDao.deleteScore(score);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean activeScore(Score score) {
        int count = 0;
        count = scoreDao.activeScore(score);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteScores(List<Score> scores) {
        int count = 0;
        for (Score score : scores) {
            if (deleteScore(score)) {
                count++;
            }
        }
        if (count == scores.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateScore(Score score) {
        boolean success = false;
        success = scoreDao.updateScore(score);
        return success;
    }

    @Override
    public boolean insertScore(Score score) {
        return scoreDao.insertScore(score);
    }
}
