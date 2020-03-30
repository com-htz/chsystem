package com.htz.chsystem.web.admin.web.controller;

import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbStudent;
import com.htz.chsystem.domain.TbTeam;
import com.htz.chsystem.domain.TbTeamStudent;
import com.htz.chsystem.web.admin.service.TbStudentService;
import com.htz.chsystem.web.admin.service.TbTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * <p>Title: StudentController</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 10:28 2020/3/26
 */

@Controller
@RequestMapping(value = "student")
public class StudentController {

    @Resource
    private TbStudentService tbStudentService;
    @Resource
    private TbTeamService tbTeamService;

    @ModelAttribute
    public TbStudent getTbStudent(Long id){
        TbStudent tbStudent = null;
        if (id != null){
            tbStudent = tbStudentService.getById(id);
        } else {
            tbStudent = new TbStudent();
        }

        return tbStudent;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model){
        List<TbTeam> tbTeams = tbTeamService.selectAll();
        model.addAttribute("tbTeams", tbTeams);
        return "student_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(){
        return "student_form";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(){
        return "student_detail";
    }

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbStudent> page(HttpServletRequest request, TbTeamStudent tbTeamStudent){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        System.out.println("tamId" + tbTeamStudent.getTeamId());
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        return tbStudentService.page(start, length, draw, tbTeamStudent);
    }
}
