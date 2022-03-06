package com.example.Springonlinestorenew.thymeleaf.service;

import com.example.Springonlinestorenew.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();
    Goods getGoodsById(Long id);
    Goods saveGoods(Goods goods);
    void deleteGoods(Long id);


}
