package furn.service;

import furn.bean.Furn;
import org.springframework.stereotype.Service;

@Service
public interface FurnService {
    void save(Furn furn);
    Furn selectById(Integer id);
}
