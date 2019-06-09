package com.test.student.controller;

import com.test.student.pojo.JsonResponse;

import java.net.HttpURLConnection;

/**
 * @author admin
 * @date 2019/6/9
 */
public class BaseController {
    /**
     * 成功，携带单个数据
     *
     * @param data
     * @param <T>`
     * @return
     */
    public <T> JsonResponse<T> success(T data) {
        JsonResponse<T> jsonResponse = new JsonResponse<>();
        jsonResponse.setCode(HttpURLConnection.HTTP_OK);
        jsonResponse.setMsg("响应成功");
        jsonResponse.setData(data);
        return jsonResponse;
    }

    /**
     * 成功，携带分页数据
     *
     * @param data
     * @param count
     * @param <T>
     * @return
     */
    public <T> JsonResponse<T> success(T data, long count) {
        JsonResponse<T> jsonResponse = new JsonResponse<>();
        jsonResponse.setCode(HttpURLConnection.HTTP_OK);
        jsonResponse.setCount(count);
        jsonResponse.setMsg("响应成功");
        jsonResponse.setData(data);
        return jsonResponse;
    }

    /**
     * 仅表示成功，不携带数据返回
     *
     * @param message 成功消息提示
     * @return json
     */
    public JsonResponse success(String message) {
        JsonResponse jsonResponse = new JsonResponse<>();
        jsonResponse.setCode(HttpURLConnection.HTTP_OK);
        jsonResponse.setMsg(message);
        return jsonResponse;
    }

    /**
     * 仅表示失败，不携带数据返回
     *
     * @param message 成功消息提示
     * @return json
     */
    public JsonResponse error(String message) {
        JsonResponse jsonResponse = new JsonResponse<>();
        jsonResponse.setCode(HttpURLConnection.HTTP_INTERNAL_ERROR);
        jsonResponse.setMsg(message);
        return jsonResponse;
    }
}
