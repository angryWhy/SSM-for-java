package Test;

import furn.bean.Furn;
import furn.dao.FurnMapper;
import furn.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class FurnAddTest {
    private ApplicationContext ioc;
    private FurnService furnService;

    @Before
    public void init(){
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取furn的service
        furnService = ioc.getBean(FurnService.class);
    }
    @Test
    public void testAdd(){
        Furn furn = new Furn(null, "香香电饭锅1111", "奥利给", new BigDecimal(21), 66, 7, "assets/images/chaowei.jpg");
        furnService.save(furn);

    }
}
