package com.htz.chsystem.web.admin.web.interceptor;

import com.htz.chsystem.commons.constant.ConstantUtils;
import com.htz.chsystem.domain.TbWorker;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //以 login 结尾的请求
        if (modelAndView != null && modelAndView.getViewName() != null && modelAndView.getViewName().endsWith("login")){
            TbWorker user = (TbWorker) httpServletRequest.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if (user != null){
                httpServletResponse.sendRedirect("/main");
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
