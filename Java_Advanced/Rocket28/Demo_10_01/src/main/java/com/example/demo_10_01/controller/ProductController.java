package com.example.demo_10_01.controller;

import com.example.demo_10_01.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @GetMapping("product")
    public String getAll(){
        log.info("Thành Công!");
        return "list";
    }
}
