package com.example.demo.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 根据Controller中抛出的异常类型返回error页面，全局
 * 若需要返回json格式，类上添加@RestController注解
 * Created by xiaoxin on 2018/3/27 .
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";


    private ModelAndView returnModelView(String message,StringBuffer url ){
        ModelAndView mav = new ModelAndView();
        mav.addObject("mess", message);
        mav.addObject("url", url);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }


    @ExceptionHandler(value = Exception.class)
    public ModelAndView ExceptionErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        return returnModelView(e.getMessage(),req.getRequestURL());
    }

    @ExceptionHandler(value = IOException.class)
    public ModelAndView iOExceptionErrorHandler(HttpServletRequest req, IOException e) throws Exception {
        return returnModelView(e.getMessage(),req.getRequestURL());
    }

}
