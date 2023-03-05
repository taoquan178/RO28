package com.tn.productController;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @GetMapping("product")
    public String getProduct(){
        return "product";
    }
}
