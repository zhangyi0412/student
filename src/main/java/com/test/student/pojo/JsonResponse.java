package com.test.student.pojo;

import lombok.Data;

/**
 * 异步响应类
 *
 * @author admin
 * @date 2019/6/9
 */
@Data
public class JsonResponse<T> {
    /**
     * 状态码，与httpclient常量一致
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 总数量
     */
    private long count;

    /**
     * 数据
     */
    private T data;
}
