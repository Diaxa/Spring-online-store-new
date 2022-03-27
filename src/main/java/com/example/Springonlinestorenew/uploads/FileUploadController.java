//package com.example.Springonlinestorenew.uploads;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import com.example.Springonlinestorenew.entity.Product;
//import com.example.Springonlinestorenew.service.ProductService;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.validation.Valid;
//
//
//@Controller
//public class FileUploadController {
//    private final  StorageService storageService;
//
//    private final ProductService productService;
//
//
//    public FileUploadController(StorageService storageService, ProductService productService) {
//        this.storageService = storageService;
//        this.productService = productService;
//    }
//
//
//
////    @GetMapping("/")
////    public String index() {
////        return "upload";
////    }
//
////    @PostMapping("/upload") // //new annotation since 4.3
////    public String singleFileUpload(@RequestParam("file") MultipartFile file,
////                                   RedirectAttributes redirectAttributes,
////                                   @RequestParam("productID")Long productId) {
////
////        if (file.isEmpty()) {
////            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
////            return "redirect:uploadStatus";
////        }
////
////        try {
////
////            // Get the file and save it somewhere
////            byte[] bytes = file.getBytes();
////            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
////            Files.write(path, bytes);
////
////            redirectAttributes.addFlashAttribute("message",
////                    "You successfully uploaded '" + file.getOriginalFilename() + "' "+ path);
////
////
////            Product product = productService.getProductById(productId);
////            product.setImage("images/" + file.getOriginalFilename());
////            productService.saveProduct(product);
////
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////        return "redirect:/uploadStatus";
////    }
//
////    @GetMapping("/uploadStatus")
////    public String uploadStatus() {
////
////        return "redirect:/products";
////    }
//
//
//
//
//}
