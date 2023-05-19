package furn.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import furn.bean.Furn;
import furn.bean.Msg;
import furn.dao.FurnMapper;
import furn.service.FurnService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class FurnController {
    @Resource
    private FurnService furnService;
    //响应客户端添加请求
    @PostMapping("/save")
    @ResponseBody
    public Msg save(@RequestBody Furn furn){
        furnService.save(furn);
        Msg success = Msg.success();
        return success;
    }
    @RequestMapping("/search-all")
    @ResponseBody
    public Msg searchAll(){
        List<Furn> furns = furnService.selectAll();
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.getExtend().put("result",furns);
        msg.setMsg("ok");
        return msg;
    }
    @RequestMapping(value = "/search-by-id",params = "id")
    @ResponseBody
    public Msg getFurn(Integer id){
        Furn furn = furnService.selectById(id);
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.getExtend().put("result",furn);
        msg.setMsg("ok");
        return msg;
    }
    @RequestMapping( "/update-by-id")
    @ResponseBody
    public Msg updateFurn(@RequestBody Furn furn){
        furnService.update(furn);
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.setMsg("ok");
        return msg;
    }
    @RequestMapping( "/deleted-by-id/{id}")
    @ResponseBody
    public Msg deletedFurn(@PathVariable("id") Integer id){
        furnService.deleted(id);
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.setMsg("ok");
        return msg;
    }

    @RequestMapping("/furn-by-page")
    @ResponseBody
    public Msg pagesFurn(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20")Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furns = furnService.selectAll();
        PageInfo pageInfo = new PageInfo(furns, pageSize);
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.getExtend().put("list",pageInfo);
        msg.setMsg("ok");
        return msg;
    }

    @RequestMapping("/furn-by-condition")
    @ResponseBody
    public Msg pagesConditionFurn(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "20")Integer pageSize,@RequestParam(defaultValue = "")String condition){
        PageHelper.startPage(pageNum, pageSize);
        List<Furn> furns = furnService.searchByCondition(condition);
        PageInfo pageInfo = new PageInfo(furns, pageSize);
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.getExtend().put("list",pageInfo);
        msg.setMsg("ok");
        return msg;
    }
}
