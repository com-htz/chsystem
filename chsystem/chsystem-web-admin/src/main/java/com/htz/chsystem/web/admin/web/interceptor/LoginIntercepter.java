package com.htz.chsystem.web.admin.web.interceptor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.htz.chsystem.commons.constant.ConstantUtils;
import com.htz.chsystem.domain.TbUser;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Pattern;
import java.util.Date;


/**
 * 登录拦截器
 */
public class LoginIntercepter implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        TbUser user = (TbUser) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);

        //未登录
        if (user == null){
            httpServletResponse.sendRedirect("/login");
        }

        //放行
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
