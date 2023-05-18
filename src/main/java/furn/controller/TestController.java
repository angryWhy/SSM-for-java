package furn.controller;


import furn.bean.Furn;
import furn.bean.Msg;
import furn.dao.FurnMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


@Controller
public class TestController {

    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }
//    @RequestMapping("/search-furn/{id}")
//    @ResponseBody
//    public Msg getFurn(@PathVariable("id") Integer id){
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
//        //获取furn的mapper
//        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
//        Furn furn = furnMapper.selectByPrimaryKey(id);
//        Msg msg = Msg.success();
//        msg.setCode(200);
//        msg.getExtend().put("result",furn);
//        msg.setMsg("ok");
//        return msg;
//    }
}
