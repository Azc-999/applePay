package com.CMe388.controller;

import com.CMe388.pojo.Product;
import com.CMe388.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/main")
    public String findAllProduct(Model model) {
        List<Product> productList = productService.findAllProduct();
        model.addAttribute("productList",productList);
        return "/admin/main";
    }
}
