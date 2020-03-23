package com.htz.chsystem.web.admin.web.controller;

import com.htz.chsystem.commons.constant.ConstantUtils;
import com.htz.chsystem.domain.TbWorker;
import com.htz.chsystem.web.admin.service.TbWorkerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器层
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 10:27 2020/3/22
 */

@Controller
public class LoginController {

    @Resource
    private TbWorkerService tbWorkerService;

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录逻辑
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String phone, @RequestParam(required = true) String password, HttpServletRequest httpServletRequest, Model model){
        TbWorker tbWorker = tbWorkerService.login(phone, password);
        //登录失败
        if (tbWorker == null){
            model.addAttribute("message","用户名或密码错误，请重新输入");
            return login();
        }
        //登录成功
        else {
            //将登录信息放入会话
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbWorker);
            return "redirect:/main";
        }
    }

    /**
     * 注销
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return "login";
    }

}
