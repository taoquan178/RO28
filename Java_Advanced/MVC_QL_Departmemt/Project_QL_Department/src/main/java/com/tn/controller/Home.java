package com.tn.controller;

import com.tn.entity.Account;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class Home {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("home")
    public String home(Model model, Principal principal,Pageable pageable){
        try {
            log.info("Trang Chủ");
            model.addAttribute("AccountLogin",accountService.getAccountByEmail(principal.getName()));
            model.addAttribute("listAccount",accountService.getListAccount(pageable));
            model.addAttribute("ListDepratment",departmentService.getListDepartment());
            List<String> listStrings = new ArrayList<>();
            for (int i = 0; i < accountService.getListAccount(pageable).getTotalPages(); i++) {
                listStrings.add(String.valueOf(i));
            }
            model.addAttribute("sl",listStrings);
            return "trang-chu";
        }catch (Exception e){
            log.error("Trang Chủ");
            model.addAttribute("error", "Truy cập không thành công! "+e.getMessage());
            return "error";
        }
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
