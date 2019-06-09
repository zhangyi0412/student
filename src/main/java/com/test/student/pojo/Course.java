package com.test.student.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author admin
 * @date 2019/6/9
 */
@Data
@Accessors(chain = true)
public class Course {
    private Long id;
    private String cname;
    private String teacher;
    private int status;
}
