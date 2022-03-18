package com.example.Springonlinestorenew.thymeleaf.service;

import com.example.Springonlinestorenew.entity.Goods;

import java.util.List;
import java.util.Optional;

public interface GoodsService {
    List<Goods> getAllGoods();
    Goods getGoodsById(Long id);
    Goods saveGoods(Goods goods);
    void deleteGoods(Long id);
    List<Goods> getAllByCategory(String category);
    List<Goods> getAllByGoodsCode(String goodsCode);

}
