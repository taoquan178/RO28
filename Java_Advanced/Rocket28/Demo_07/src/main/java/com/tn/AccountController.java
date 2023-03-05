package com.tn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;

@Controller
public class AccountController {

    @GetMapping("home")
    public String goHome(Model model) {
        model.addAttribute("name","Quân");
        model.addAttribute("age",18);
        model.addAttribute("product",new Product(1, "Car","1000"));
        model.addAttribute("listProduct", Arrays.asList(
                new Product(2, "Car2","2000"),
                new Product(3, "Car3","3000"),
                new Product(4, "Car4","4000")
        ));
        return "home";
    }

    @GetMapping("account/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        System.out.println(id);
        //accountRepo.delete(id);
        //List<Product> products = accountRepo.findAll();
        //model.addAttribute("listProduct",products);
        return "redirect:/home";
    }

    @GetMapping("account/add/{id}")
    public String add(Model model, @PathVariable Integer id){
        System.out.println(id);
        //accountRepo.delete(id);
        //List<Product> products = accountRepo.findAll();
        //model.addAttribute("listProduct",products);
        return "redirect:/home";
    }

}
