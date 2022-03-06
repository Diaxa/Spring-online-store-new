package com.example.Springonlinestorenew.controller;

import com.example.Springonlinestorenew.entity.Goods;
import com.example.Springonlinestorenew.thymeleaf.service.GoodsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api")
public class GoodsController {

    @Autowired
    private GoodsServiceImpl goodsServiceImpl;

    @GetMapping("/goods")
    public List<Goods> getGoods() {
        List<Goods> goodsList =  goodsServiceImpl.getAllGoods();
        log.info("Goods category size " + goodsList.size() );
       return goodsList;
    }
    @GetMapping("/goods/{id}")
    public ResponseEntity<Goods> getGoods(@PathVariable Long id) {
        Goods goods = goodsServiceImpl.getGoodsById(id);

        return new ResponseEntity(goods, HttpStatus.OK);
    }

    @PostMapping("/goods")
    public Goods getGoods( @RequestBody Goods goods){
        return  goodsServiceImpl.saveGoods(goods);
    }

    @DeleteMapping("/goods/{id}")
    public void getGoodss(@PathVariable Long id) {
        goodsServiceImpl.deleteGoods(id);
    }
    @GetMapping("/find/{category}")
    public List<Goods> getGoods(@PathVariable String category) {
        List<Goods> goodsCategory =  goodsServiceImpl.getAllByCategory(category);
        log.info("Goods category size " + goodsCategory.size() );
        return  goodsCategory;
    }

}
