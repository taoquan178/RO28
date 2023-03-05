package com.tn.controller;

import com.tn.entity.Account;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@Slf4j
public class Home {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("home")
    public String home(Model model, Principal principal){
        log.info("Trang Chủ");
        model.addAttribute("AccountLogin",accountService.getAccountByEmail(principal.getName()));
        model.addAttribute("listAccount",accountService.getListAccount());
        model.addAttribute("ListDepratment",departmentService.getListDepartment());
        return "trang-chu";
    }

    @GetMapping("")
    public String goHome(){
        return "redirect:/home";
    }

    @GetMapping("login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("logout")
    public String logout(){
        return "redirect:/login";
    }

    @GetMapping("dangky")
    public String dangky(){
        return "dangky";
    }

    @PostMapping("savedangky")
    public String savedangky(@ModelAttribute Account account){
        accountService.saveAccount(account);
        return "redirect:/login";
    }
}
