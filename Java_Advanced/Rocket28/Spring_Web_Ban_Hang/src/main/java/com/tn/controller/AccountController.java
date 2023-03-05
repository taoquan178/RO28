package com.tn.controller;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.repository.IAccountRepository;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@RestController
@Controller
@Data
@Validated
@RequestMapping("admin")
@Slf4j
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("account/home")
    public String getAccount(Model model) {
        log.info("account/home");
        List<AccountDTO> accounts = accountService.getListAccount();
        model.addAttribute("listAccount", accounts);
        return "account-home";

    }

    @GetMapping("account/home/search")
    public String searchAccount(Model model, @RequestParam String data) {
        log.info("account/home/search");
        model.addAttribute("listAccount", accountService.searchListAccount(data));
        return "account-home";

    }

    @GetMapping("account/delete/{id}")
    public String deleteAccount(Model model, @PathVariable Integer id,RedirectAttributes redirAttrs) {
        log.info("account/delete/" + id);
        boolean check = accountService.deleteAccount(id);
        if (check){
            redirAttrs.addFlashAttribute("success", "Xoá thành công!");
            return "redirect:/admin/account/home";
        }else {
            redirAttrs.addFlashAttribute("error", "Xoá thất bại!");
            return "redirect:/admin/account/home";
        }

    }

    @GetMapping("account/add")
    public String addAccount(Model model) {
        log.info("account/add");
        model.addAttribute("ListDepratment", departmentService.getListDepartment());
        return "account-add";

    }

    @PostMapping("account/save")
    public String saveAccount(@ModelAttribute  Account account) {
        log.info("account/add " + account);
        accountService.saveAccount(account);
        return "redirect:/admin/account/home";

    }

    @GetMapping("account/edit/{id}")
    public String editAccount(Model model, @PathVariable Integer id) {
        log.info("account/edit/" + id);
        model.addAttribute("account", accountService.updateAccount(id).get());
        model.addAttribute("ListDepratment", departmentService.getListDepartment());
        return "account-update";

    }

    @PostMapping("account/update")
    public String updateAccount(@ModelAttribute Account account) {
        log.info("account/update");
        accountService.saveAccount(account);
        return "redirect:/admin/account/home";

    }


}
