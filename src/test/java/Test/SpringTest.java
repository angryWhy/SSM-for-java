package Test;

import furn.bean.Furn;
import furn.dao.FurnMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class SpringTest {
    @Test
    public void add() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取furn的mapper
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        System.out.println(furnMapper);
        //添加数据
        Furn furn = new Furn(null, "超威电竞椅------", "超威", new BigDecimal(180), 66, 7, "assets/images/chaowei.jpg");
        int affected = furnMapper.insertSelective(furn);
        System.out.println(affected);
    }

    @Test
    public void delete() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取furn的mapper
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        System.out.println(furnMapper);
        //添加数据
        int affected = furnMapper.deleteByPrimaryKey(15);
        System.out.println(affected);
    }

    @Test
    public void update() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取furn的mapper
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn();
        furn.setId(14);
        furn.setMarker("胜利");
        furn.setName("胜利大桌子");
        int affected = furnMapper.updateByPrimaryKeySelective(furn);
        System.out.println(affected);

    }
}
