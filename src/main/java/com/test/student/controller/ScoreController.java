package com.test.student.controller;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.JsonResponse;
import com.test.student.pojo.Score;
import com.test.student.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Controller
@RequestMapping("/score")
public class ScoreController extends BaseController {
    @Resource
    ScoreService scoreService;

    /**
     * 分页查询用户
     * @param score 条件查询参数
     * @param page 页码
     * @param limit 页大小
     * @return
     */
    @ResponseBody
    @GetMapping("/listScores")
    public JsonResponse<List<Score>> listScores(Score score, @RequestParam(name = "page", defaultValue = "1") int page,
                                             @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageInfo<Score> pageInfo = scoreService.listScores(score, page, limit);
        return success(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 禁用用户
     * @param score
     * @return
     */
    @ResponseBody
    @PostMapping("/delete")
    public JsonResponse<Boolean> deleteScore(@RequestBody Score score) {
        boolean success = scoreService.deleteScore(score);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 激活用户
     * @param score
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/active")
    public JsonResponse<Boolean> activeScore(@RequestBody Score score)   {
        boolean success = scoreService.activeScore(score);
        if (success) {
            return success("激活成功");
        } else {
            return error("激活失败");
        }
    }

    /**
     * 批量激活
     * @param scores
     * @return
     */
    @ResponseBody
    @PostMapping("/deletes")
    public JsonResponse<Boolean> deleteScores(@RequestBody List<Score> scores){
        boolean success = scoreService.deleteScores(scores);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 编辑用户和新增用户，根据用参数是否包含id区分
     * @param score
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/update")
    public JsonResponse<Boolean> updateScore(@RequestBody  Score score){
        if(score.getId()!=null){
            boolean success = scoreService.updateScore(score);
            if (success) {
                return success("修改成功");
            } else {
                return error("修改失败");
            }
        }else {

            boolean success = scoreService.insertScore(score);
            if (success) {
                return success("新增成功");
            } else {
                return error("新增失败");
            }
        }

    }
}