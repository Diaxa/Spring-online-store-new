package com.example.Springonlinestorenew.controller;

import com.example.Springonlinestorenew.entity.Goods;
import com.example.Springonlinestorenew.thymeleaf.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsServiceImpl;

    @GetMapping("/goods")
    public List<Goods> getGoods() {
       return goodsServiceImpl.getAllGoods();
    }
    @GetMapping("/goods/{id}")
    public ResponseEntity<Goods> getGoods(@PathVariable Long id) {
        Goods goods = goodsServiceImpl.getGoodsById(id);

        return new ResponseEntity(goods, HttpStatus.OK);
    }

    @PostMapping("/goods")
    public Goods getGoods(@RequestBody Goods goods){
        return  goodsServiceImpl.saveGoods(goods);
    }

    @DeleteMapping("/goods/{id}")
    public void getGoodss(@PathVariable Long id) {
        goodsServiceImpl.deleteGoods(id);
    }
}
