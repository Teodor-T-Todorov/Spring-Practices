package com.example.ex8_springmvcproduct.controllers;

import com.example.ex8_springmvcproduct.model.Product;
import com.example.ex8_springmvcproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/products")
    public String addProduct(
            @RequestParam String name,
            @RequestParam double price,
            Model model
    ) {
        Product p = new Product(name, price);
        productService.addProduct(p);

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }


    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }
}
