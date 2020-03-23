package com.htz.chsystem.web.admin.web.controller;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbWorker;
import com.htz.chsystem.web.admin.service.TbWorkerService;
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
 * 用户控制器
 * <p>Title: UserController</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 10:34 2020/3/22 
 */

@Controller
@RequestMapping(value = "worker")
public class WorkerController {

    @Resource
    private TbWorkerService tbWorkerService;

    @ModelAttribute
    public TbWorker getTbWorker(Long id) {
        TbWorker tbWorker = null;
        // id 不为空，则从数据库获取
        if (id != null) {
            tbWorker = tbWorkerService.getById(id);
        } else {
            tbWorker = new TbWorker();
        }
        return tbWorker;
    }

    /**
     * 跳转到用户列表页
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "worker_list";
    }

    /**
     * 跳转用户表单页
     *
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form() {
        return "worker_form";
    }

    /**
     * 保存用户信息
     *
     * @param tbWorker
     * @return
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbWorker tbWorker, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbWorkerService.save(tbWorker);

        // 保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/worker/list";
        }

        // 保存失败
        else {
            model.addAttribute("baseResult", baseResult);
            return "worker_form";
        }
    }

    /**
     * 删除用户信息
     * <p>Title: UserController</p>
     * <p>Description: </p>
     *
     * @author EnergyFiled
     * @version 1.0.0
     */

    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResult delete(String ids) {
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbWorkerService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除用户成功");
        } else {
            baseResult = BaseResult.fail("删除用户失败");
        }

        return baseResult;
    }

    /**
     * 显示用户详情
     *
     * @return
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public String detail() {
        return "worker_detail";
    }

    /**
     * 用户列表分页展示
     * <p>Title: UserController</p>
     * <p>Description: </p>
     *
     * @author EnergyFiled
     * @version 1.0.0
     */

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public PageInfo<TbWorker> page(HttpServletRequest request, TbWorker tbWorker) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        // 封装 Datatables 需要的结果
        PageInfo<TbWorker> pageInfo = tbWorkerService.page(start, length, draw, tbWorker);

        return pageInfo;
    }
}
