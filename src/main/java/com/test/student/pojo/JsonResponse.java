package com.test.student.pojo;

import lombok.Data;

/**
 * 异步响应类
 *
 * @author zhangyi@g7.com.cn
 * @date 2019/3/23
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
