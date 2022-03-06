package com.example.Springonlinestorenew.thymeleaf.controller;


import com.example.Springonlinestorenew.entity.Goods;
import com.example.Springonlinestorenew.repository.GoodsRepository;
import com.example.Springonlinestorenew.thymeleaf.service.GoodsService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Data
@Controller
@RequestMapping("/goods")
public class GoodsMvcController {

    private final GoodsService goodsService;

    @GetMapping()
    public String listGoods(Model model){
        List<Goods> goodsList = goodsService.getAllGoods();
        model.addAttribute("goodsList", goodsList);
        return "goods-list";
    }
    @GetMapping("/form")
    public String goodsForm(Model model){
        Goods goods = new Goods();
        model.addAttribute("goods", goods);
        return "goods-form";
    }

    @GetMapping("/formForUpdate")
    public String goodsFormForUpdate(@RequestParam("goodsId") Long goodsId, Model model){
        Goods goods = goodsService.getGoodsById(goodsId);
        model.addAttribute("goods", goods);
        return "/goods-form";
    }

    @PostMapping("/save")
    public String saveGoods(@Valid @ModelAttribute("goods") Goods goods,BindingResult result){
        if (result.hasErrors()){
            String errorMessage = "";
            for (FieldError error : result.getFieldErrors()){
                errorMessage += error.getField() + ": " + error.getDefaultMessage() + "\n";
            }
            return "goods-form";
        }
        goodsService.saveGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("/delete")
    public String deleteGoods(@RequestParam("goodsId") Long id){
        goodsService.deleteGoods(id);
        return "redirect:/goods";
    }










}
