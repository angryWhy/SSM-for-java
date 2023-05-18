package furn.service;

import furn.bean.Furn;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FurnService {
    //添加
    void save(Furn furn);
    Furn selectById(Integer id);
    //查询所有
    List<Furn> selectAll();

    //更新
    void update(Furn furn);
    //删除
    void deleted(Integer id);

}
