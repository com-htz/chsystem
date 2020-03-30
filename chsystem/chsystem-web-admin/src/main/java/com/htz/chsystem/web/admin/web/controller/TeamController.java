package com.htz.chsystem.web.admin.web.controller;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbStudent;
import com.htz.chsystem.domain.TbTeam;
import com.htz.chsystem.web.admin.service.TbTeamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <p>Title: TeamController</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 22:51 2020/3/24 
 */

@Controller
@RequestMapping(value = "team")
public class TeamController {

    @Resource
    private TbTeamService tbTeamService;

    /**
     *
     * @Description: 将班级信息储存在TbTeam中
     *
     * @auther: EnergyFiled
     * @date: 22:45 2020/3/24
     * @param: [id]
     * @return: TbTeam
     *
    */
    @ModelAttribute
    public TbTeam getTbTeam(Long id){
        TbTeam tbTeam = null;
        if (id != null){
            tbTeam = tbTeamService.getById(id);
        } else {
            tbTeam = new TbTeam();
        }
        return tbTeam;
    }

    /**
     * 跳转到班级列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "team_list";
    }

    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(){
        return "team_form";
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail(){
        return "team_detail";
    }


    /**
     *
     * @Description: 保存班级信息
     *
     * @auther: EnergyFiled
     * @date: 22:45 2020/3/24
     * @param: [tbTeam, model, redirectAttributes]
     * @return: String
     *
    */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbTeam tbTeam, Model model, RedirectAttributes redirectAttributes){
        //获取保存状态
        BaseResult baseResult = tbTeamService.save(tbTeam);
        //保存成功
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/team/list";
        }
        //保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "team_form";
        }
    }

    /**
     *
     * @Description: 删除班级
     * TODO 待完善
     * @auther: EnergyFiled
     * @date: 22:46 2020/3/24
     * @param: [ids]
     * @return: BaseResult
     *
    */
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            tbTeamService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除班级成功");

        } else {
            baseResult = BaseResult.fail("删除班级失败");
        }
        return baseResult;
    }

    /**
     *
     * @Description: 分页查询班级
     *
     * @auther: EnergyFiled
     * @date: 22:47 2020/3/24
     * @param: [request, tbTeam]
     * @return: TbTeam
     *
    */
    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbTeam> page(HttpServletRequest request, TbTeam tbTeam){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);
        return tbTeamService.page(start, length, draw, tbTeam);
    }
}
