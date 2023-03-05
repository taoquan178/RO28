package com.tn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
public class AccountController {

    @GetMapping("home")
    public String goHome(Model model) {
//        model.addAttribute("name", "Ngoc");
//        model.addAttribute("age", 18);
//        model.addAttribute("product", new Product(1, "Car", "1000"));
        model.addAttribute("listProduct", Arrays.asList(
                new Product(2, "Bike", "1200"),
                new Product(3, "Truck", "1400")));

        System.out.println("home path");

        return "home";
    }

    @GetMapping("account/add")
    public String add(Model model) {
        return "account-add";
    }

    @PostMapping("account/save")
    public String save(@ModelAttribute Product product) {
        // goi ham save de luu
        System.out.println(product);
        return "redirect:/home";
    }

    @GetMapping("account/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        // find by id
        model.addAttribute("product", new Product(1, "Car", "1000"));
        return "account-edit";
    }

    @PostMapping("account/update")
    public String update(@ModelAttribute Product product) {
        // goi ham save de update
        System.out.println(product);
        return "redirect:/home";
    }

    @GetMapping("account/delete/{id}")
    public String delete(Model model, @PathVariable Integer id) {
        System.out.println(id);
        // accountRepo.delete(id);
        // List<Product> products = accountRepo.findAll();
        // model.addAttribute("listProduct", products);

        return "redirect:/home";
    }

}
