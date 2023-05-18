package furn.service.iml;

import furn.bean.Furn;
import furn.dao.FurnMapper;
import furn.service.FurnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class FurnServiceIpl implements FurnService {
    //注入FurnMapper接口对象
    @Resource
    private FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {
        furnMapper.insertSelective(furn);
    }

    @Override
    public Furn selectById(Integer id) {
        Furn furn = furnMapper.selectByPrimaryKey(id);
        return furn;
    }

}
