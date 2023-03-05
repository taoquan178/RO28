package com.tn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("product")
    public List<String> getHome() {
        List<String> list = new ArrayList<>();
        list.add("Coffee");
        list.add("Milk");
        return list;
    }
}
