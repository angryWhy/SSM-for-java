package furn.dao;

import furn.bean.Furn;
import furn.bean.FurnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;


public interface FurnMapper {
    long countByExample(FurnExample example);

    int deleteByExample(FurnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Furn record);

    int insertSelective(Furn record);

    List<Furn> selectByExample(FurnExample example);

    Furn selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Furn record, @Param("example") FurnExample example);

    int updateByExample(@Param("record") Furn record, @Param("example") FurnExample example);

    int updateByPrimaryKeySelective(Furn record);

    int updateByPrimaryKey(Furn record);
}