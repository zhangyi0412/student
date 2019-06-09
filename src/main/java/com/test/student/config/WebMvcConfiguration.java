package com.test.student.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin
 * @date 2019/6/9
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配置ui（重定向或者直接输入的请求）->与视图
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/user_list.html").setViewName("user_list");
        registry.addViewController("/student_list.html").setViewName("student_list");
        registry.addViewController("/course_list.html").setViewName("course_list");
        registry.addViewController("/score_list.html").setViewName("score_list");

    }

    //    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index", "/login", "/user/login", "/asserts/**");
//    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //第一个方法设置访问路径前缀，第二个方法设置资源路径
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
