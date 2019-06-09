package com.test.student.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author admin
 * @date 2019/6/9
 */
@Data
@Accessors(chain = true)
public class Score {
    private Long id;
    private Student student;
    private Course course;
    private long grade;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    //搜索关键字
    private String key;
}
