package com.tn.controller;

import com.tn.dto.ProductDto;
import com.tn.entity.Product;
import com.tn.service.IProductService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("getall")
    public List<ProductDto> getAllProduct(){
        return productService.getAll();
    }

    @GetMapping("get/{id}")
    public ProductDto getProduct(@PathVariable Integer id){
        Product product = productService.getProductById(id);

        ProductDto productDto = modelMapper.map(product,ProductDto.class);

        return productDto;
    }

}
