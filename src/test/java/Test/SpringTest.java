package Test;

import furn.bean.Furn;
import furn.dao.FurnMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class SpringTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取furn的mapper
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        System.out.println(furnMapper);
        //添加数据
        Furn furn = new Furn(null, "超威电竞椅", "超威", new BigDecimal(180), 66, 7, "assets/images/chaowei.jpg");
        int affected = furnMapper.insertSelective(furn);
        System.out.println(affected);
    }
}
