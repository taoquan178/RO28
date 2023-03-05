package com.tn.controller;

import com.tn.entity.Product;
import com.tn.repository.IProductRepository;
import com.tn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    IProductRepository productRepo;

    @GetMapping("home")
    public String getHome() {
        return "Home";
    }


}
