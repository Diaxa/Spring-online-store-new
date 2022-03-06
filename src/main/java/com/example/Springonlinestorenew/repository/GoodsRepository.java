package com.example.Springonlinestorenew.repository;

import com.example.Springonlinestorenew.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods,Long> {


}
