package com.example.Springonlinestorenew.controller;


import com.example.Springonlinestorenew.entity.Product;

import com.example.Springonlinestorenew.service.ProductService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Data
@Controller
@RequestMapping("/products")
public class ProductMvcController {

    private final ProductService productService;
    private static String UPLOADED_FOLDER = "src/main/resources/static/images/"; //saglabās šajā vietā ja nav

    @GetMapping()
    public String listProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productsList", productList);
        return "product-list";
    }

    @GetMapping("/form")
    public String productForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    @GetMapping("/formForUpdate")
    public String productFormForUpdate(@RequestParam("productID") Long goodsId, Model model) {
        Product product = productService.getProductById(goodsId);
        model.addAttribute("product", product);
        return "product-form";
    }

//    @PostMapping("/save")
//    public String saveProducts(@Valid @ModelAttribute("product") Product product, BindingResult result){
//        if (result.hasErrors()){
//            String errorMessage = "";
//            for (FieldError error : result.getFieldErrors()){
//                errorMessage += error.getField() + ": " + error.getDefaultMessage() + "\n";
//            }
//            return "product-form";
//        }
//        productService.saveProduct(product);
//        return "redirect:/products";
//    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/filter")
    public String filteredList(@RequestParam(required = false, name = "category") String category, String goodsCode, Model model) {

        List<Product> productListCategory = productService.getAllByCategory(category);
        model.addAttribute("product", productListCategory);


        return "product-find";
    }

    ////Second way to search by category
//@RequestMapping(path = {"/","/filter"})
//public String searchForGoods(Goods products, Model model, String category) {
//
//    if (category != null) {
//        List<Goods> list = goodsService.getAllByCategory(category);
//        model.addAttribute("products", list);
//    } else {
//        List<Goods> list = goodsService.getAllGoods();
//        model.addAttribute("products", list);
//    }
//    return "products-find";
//}

    @GetMapping("/filter/code")
    public String filteredListCode(@RequestParam(required = false, name = "code") String productCode, Model model) {
        List<Product> productListCode = productService.getAllByCode(productCode);
        model.addAttribute("product", productListCode);
        return "product-find";
    }

    @PostMapping("/saveUpload")
    public String saveUploadData(@Valid @ModelAttribute("product") Product product,
                                 BindingResult result,
                                 @RequestParam("file") MultipartFile file) {

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);


            if (result.hasErrors()) {
                String errorMessage = "";
                for (FieldError error : result.getFieldErrors()) {
                    errorMessage += error.getField() + ": " + error.getDefaultMessage() + "\n";
                }
                return "product-form";
            }


            product.setImage("images/" + file.getOriginalFilename());
            productService.saveProduct(product);


        } catch (IOException e) {
            e.printStackTrace();
        }
        productService.saveProduct(product);
        return "redirect:/products";

    }
}
