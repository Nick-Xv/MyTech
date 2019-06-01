package com.woxue.mt.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();
        //如果路径里面包含login关键字表明是登录相关的业务，直接放行
        if(url.toLowerCase().indexOf("login")>=0){
            return true;
        }
        //如果路径里面包含register关键字表明是注册业务，也放行
        else if(url.toLowerCase().indexOf("register")>=0){
            return true;
        }

        //如果路径包含search关键字，表明是搜索业务，放行
        else if(url.toLowerCase().indexOf("search")>=0){
            return true;
        }

        //如果路径包含关键字，表明是科技成果业务，放行
        else if(url.toLowerCase().indexOf("essay")>=0 || url.toLowerCase().indexOf("patent")>=0 || url.toLowerCase().indexOf("professor")>=0 || url.toLowerCase().indexOf("index")>=0){
            return true;
        }

        //通过session判断用户是否处在已登录状态，已登录状态则放行
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("user")!=null){
            return true;
        }
        //如果没有登录，就重定向到登录界面去
        httpServletResponse.sendRedirect("/MyTech/to_login");
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
