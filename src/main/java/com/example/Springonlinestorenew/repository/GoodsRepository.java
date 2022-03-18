package com.example.Springonlinestorenew.repository;

import com.example.Springonlinestorenew.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Long> {



    List<Goods> findByCategory (String category);
    List<Goods> findByGoodsCode (String goodsCode);

}
