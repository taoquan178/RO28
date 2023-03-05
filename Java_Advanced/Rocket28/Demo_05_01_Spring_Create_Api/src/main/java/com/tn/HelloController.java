package com.tn;

import com.tn.entity.Product;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("hello")
public class HelloController {

//    // lấy dữ liệu
//    @GetMapping(value ="/getData")
//    public String hello(){
//        return "hello world";
//    }
//
//    // luu data
//    @PostMapping("/save")
//    public String helloPost(){
//        return "Method Post";
//    }
//
//    // update data
//    @PutMapping("/update")
//    public String helloPut(){
//        return "Method Put";
//    }
//
//    // xoá bản ghi
//    @DeleteMapping("/delete")
//    public String helloDelete(){
//        return "Method Delete";
//    }

    @GetMapping("/getData")
    public ResponseEntity<?> hello(){
        Product product = new Product();
        product.setId(1);
        product.setProductName("Ô Tô");

        List<Product> products = new ArrayList<>();
        products.add(product);

        if(products.size() >0){
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("không có dữ liệu", HttpStatus.BAD_REQUEST);
        }

    }
}
