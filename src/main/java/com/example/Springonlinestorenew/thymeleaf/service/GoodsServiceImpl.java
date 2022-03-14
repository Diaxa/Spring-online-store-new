package com.example.Springonlinestorenew.thymeleaf.service;

import com.example.Springonlinestorenew.entity.Goods;
import com.example.Springonlinestorenew.repository.GoodsRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();
    }

    public Goods getGoodsById(Long id) {
        Optional<Goods> maybeGoods = goodsRepository.findById(id);

        if (maybeGoods.isEmpty()) {
            throw new RuntimeException("Employee with id " + id + " was not found.");
        }

        return maybeGoods.get();
    }

    public Goods saveGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public void deleteGoods(Long id) {
        goodsRepository.deleteById(id);
    }

    public  List<Goods> getAllByCategory(String category){
        return goodsRepository.findByCategory(category);
    }








}
