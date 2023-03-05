package com.tn.controller;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.repository.IAccountRepository;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Parameter;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
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
    public String getAccount(Model model,Pageable pageable) {
        try {
            log.info("account/home");
            model.addAttribute("listAccount", accountService.getListAccount(pageable));
            return "account-home";
        } catch (Exception e) {
            log.error("account/home" + " False");
            model.addAttribute("error","Truy cập không thành công! "+ e.getMessage());
            return "error";
        }
    }

    @GetMapping("account/home/search")
    public String searchAccount(Model model, @RequestParam String data) {
        try {
            log.info("account/home/search");
            model.addAttribute("listAccount", accountService.searchListAccount(data));
            return "account-home";
        } catch (Exception e) {
            log.error("account/home/search" + " False");
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @GetMapping("account/delete/{id}")
    public String deleteAccount(Model model, @PathVariable Integer id,RedirectAttributes redirAttrs) {
        try {
            log.info("account/delete/" + id);
            boolean check = accountService.deleteAccount(id);
            if (check){
                redirAttrs.addFlashAttribute("success", "Xoá thành công!");
                return "redirect:/admin/account/home";
            }
            else {
                redirAttrs.addFlashAttribute("error", "Xoá thất bại!");
                return "redirect:/admin/account/home";
            }
        } catch (Exception e) {
            log.error("account/delete/" + id + " False");
            model.addAttribute("error","Xoá thất bại! "+ e.getMessage());
            return "error";
        }
    }

    @GetMapping("account/add")
    public String addAccount(Model model) {
        try {
            log.info("account/add");
            model.addAttribute("ListDepratment", departmentService.getListDepartment());
            return "account-add";
        } catch (Exception e) {
            log.error("account/add" + " False");
            model.addAttribute("error","Truy cập không thành công! "+ e.getMessage());
            return "error";
        }
    }

    @PostMapping("account/save")
    public String saveAccount(@ModelAttribute Account account,RedirectAttributes redirAttrs,Model model) {
        try {
            log.info("account/add " + account);
            accountService.saveAccount(account);
            redirAttrs.addFlashAttribute("success", "Thêm thành công!");
            return "redirect:/admin/account/home";
        } catch (ConstraintViolationException e){
            log.error("account/save " + account + " False");
            model.addAttribute("error", "Email này đã tồn tại! "+e);
            return "error";
        }
        catch (Exception e) {
            if(e.getCause() != null && e.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
                SQLIntegrityConstraintViolationException sql_violation_exception = (SQLIntegrityConstraintViolationException) e.getCause().getCause() ;
                model.addAttribute("error", "Email này đã tồn tại! " +  sql_violation_exception.getMessage());
                log.error("account/save " + account + " False" + " Email này đã tồn tại! "+  sql_violation_exception.getMessage());
                return "error";
            } else {
                log.error("account/save " + account + " False" + e.getMessage());
                model.addAttribute("error", "Thêm không thành công! "+e.getMessage());
                return "error";
            }
        }
    }

    @GetMapping("account/edit/{id}")
    public String editAccount(Model model, @PathVariable Integer id) {
        try {
            log.info("account/edit/" + id);
            model.addAttribute("account", accountService.updateAccount(id).get());
            model.addAttribute("ListDepratment", departmentService.getListDepartment());
            return "account-update";

        } catch (Exception e) {
            log.error("account/edit/ " + id + " False");
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }

    @PostMapping("account/update")
    public String updateAccount(@ModelAttribute Account account,Model model,RedirectAttributes redirAttrs) {
        try {
            log.info("account/update");
            accountService.updateAccount(account);
            redirAttrs.addFlashAttribute("success", "Cập nhập thành công!");
            return "redirect:/admin/account/home";
        } catch (Exception e) {
            log.error("account/update" + " False");
            model.addAttribute("error", "Cập nhập không thành công! "+e.getMessage());
            return "error";
        }
    }


    //    @GetMapping("getall")
//    public List<Account> getAccount(){
//        List<Account> accounts = accountRepo.findAll();
//        return accounts;
//    }
//
//    @GetMapping("search")
//    public ResponseEntity<?> searchAccount(@RequestParam Integer id){
//        Optional<Account> accounts = accountRepo.findById(id);
//        if (accounts.isEmpty()){
//            return new ResponseEntity<>("Account ID "+ id +" dose not exist!", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(accounts.get(), HttpStatus.OK);
//    }
//
//    @GetMapping("get/{id}")
//    public ResponseEntity<?> getByIdAccount(@PathVariable(name="id") int id){
//        Optional<Account> accounts = accountRepo.findById(id);
//        if (accounts.isEmpty()){
//            return new ResponseEntity<>("Account ID "+ id +" dose not exist!", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>(accounts.get(), HttpStatus.OK);
//    }
//
//    @PostMapping("add")
//    public String addAccount(@RequestBody Account account){
//        accountRepo.save(account);
//        return "Create Successfully!";
//    }
//
//    @PutMapping("update/{id}")
//    public String updateAccount(@PathVariable Integer id, @RequestBody Account account){
//        Optional<Account> accounts = accountRepo.findById(id);
//        if(accounts.isEmpty()){
//            return "Account ID "+ id +" dose not exist!";
//        }
//        account.setId(id);
//        accountRepo.save(account);
//        return "Update account ID "+ id +" successfully!";
//    }
//
//    @DeleteMapping("delete/{id}")
//    public String deleteAccount(@PathVariable Integer id){
//        Optional<Account> accounts = accountRepo.findById(id);
//        if (accounts.isEmpty()){
//            return "Account ID "+ id +" dose not exist!";
//        }
//        accountRepo.deleteById(id);
//        return "Detele account " + id +" successfully!";
//    }
}
