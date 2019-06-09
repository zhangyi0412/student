package com.test.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author admin
 * @date 2019/6/9
 */
@SpringBootApplication
// 开启监听器
@ServletComponentScan
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
