package furn.controller;

import furn.bean.Furn;
import furn.bean.Msg;
import furn.dao.FurnMapper;
import furn.service.FurnService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @RequestMapping(value = "/search-furn",params = "id")
    @ResponseBody
    public Msg getFurn(Integer id){
        Furn furn = furnService.selectById(id);
        Msg msg = Msg.success();
        msg.setCode(200);
        msg.getExtend().put("result",furn);
        msg.setMsg("ok");
        return msg;
    }
}
