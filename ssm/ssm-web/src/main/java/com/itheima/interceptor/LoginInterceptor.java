package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 判断用户登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor{

        /**
         *
     *前置增强的方法：preHandle
     * 方法参数：
     *      request：请求对象
     *      response：响应对象
     *      handler：目标处理器方法
     */

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        // 1.用户访问商品列表数据，需要检出是否登录
        // 2.如果用户已经登录，直接访问商品列表
        // 3.如果用户未登录，先去登录页面执行登录，成功登录以后，再访问商品列表数据

        // 获取session对象
        HttpSession session = request.getSession();

        // 获取用户数据
        Object user = session.getAttribute("user");

        // 判断用户是否为空
        if(user != null){
            System.out.println("用户已经登录，放行......");
            return true;
        }else {
            // 用户未登录
            System.out.println("用户未登录，请先登录.......");
            response.sendRedirect(request.getContextPath()+"/user/login");

            return false;
        }

    }


/**
     *后置增强的方法：postHandle
     * 方法参数：
     *      request：请求对象
     *      response：响应对象
     *      handler：目标处理器方法
     *      modelAndView：模型和视图
     */

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

    }


/**
     *后置增强的方法：afterCompletion
     * 方法参数：
     *      request：请求对象
     *      response：响应对象
     *      handler：目标处理器方法
     *      ex：异常对象
     */

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {


    }

}
