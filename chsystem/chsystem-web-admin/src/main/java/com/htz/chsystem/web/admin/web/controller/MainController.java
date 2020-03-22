package com.htz.chsystem.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页跳转控制器
 * <p>Title: MainController</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 10:27 2020/3/22 
 */

@Controller
public class MainController {
    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
