package com.example.Springonlinestorenew.thymeleaf.controller;


import com.example.Springonlinestorenew.entity.Goods;
import com.example.Springonlinestorenew.image.FileUploadUtil;
import com.example.Springonlinestorenew.repository.GoodsRepository;
import com.example.Springonlinestorenew.thymeleaf.service.GoodsService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.io.IOException;
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
    public String goodsFormForUpdate(@RequestParam("goodsID") Long goodsId, Model model){
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

    @GetMapping("/filter")
    public String filteredList (@RequestParam(required=false,name="category") String category,String goodsCode,Model model){

                List<Goods> goodsListCategory = goodsService.getAllByCategory(category);
                model.addAttribute("goods", goodsListCategory);


            return "goods-find";
        }

        ////Second way to search by category
//@RequestMapping(path = {"/","/filter"})
//public String searchForGoods(Goods goods, Model model, String category) {
//
//    if (category != null) {
//        List<Goods> list = goodsService.getAllByCategory(category);
//        model.addAttribute("goods", list);
//    } else {
//        List<Goods> list = goodsService.getAllGoods();
//        model.addAttribute("goods", list);
//    }
//    return "goods-find";
//}

    @GetMapping("/filter/code")
    public String filteredListCode (@RequestParam(required=false,name="goodsCode") String goodsCode,Model model){
        List<Goods> goodsListCode = goodsService.getAllByGoodsCode(goodsCode);
        model.addAttribute("goods", goodsListCode);
        return "goods-find";
    }
    @PostMapping("/image/save")
    public RedirectView saveImage(Goods goods,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        goods.setPhotos(fileName);

        Goods savedGoods = goodsService.saveGoods(goods);

        String uploadDir = "goods-photos/" + savedGoods.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/goods", true);
    }

}
