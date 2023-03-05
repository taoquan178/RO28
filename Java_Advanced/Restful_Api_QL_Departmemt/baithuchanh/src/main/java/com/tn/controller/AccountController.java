package com.tn.controller;

import com.tn.dto.AccountDTO;
import com.tn.entity.Account;
import com.tn.from.FromCreateAccount;
import com.tn.from.FromUpdateAccount;
import com.tn.repository.IAccountRepository;
import com.tn.repository.IDepartmentRepository;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
//@Controller
@Data
@RequestMapping("account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<AccountDTO> accountDTOs = accountService.getListAccount();
        return new ResponseEntity<>(accountDTOs, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer id){
        String alert = accountService.deleteAccount(id);
        return new ResponseEntity<>(alert, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addAccount(@RequestBody FromCreateAccount fromAccount){
        AccountDTO accountDTO = modelMapper.map(accountService.saveAccount(fromAccount),AccountDTO.class);
        return new ResponseEntity<>(accountDTO, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Integer id, @RequestBody FromUpdateAccount fromAccount){
        AccountDTO accountDTO = modelMapper.map(accountService.updateAccount(id,fromAccount),AccountDTO.class);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }



//    @GetMapping("account/home")
//    public String getAccount(Model model) {
//        log.info("account/home");
//        List<AccountDTO> accounts = accountService.getListAccount();
//        model.addAttribute("listAccount", accounts);
//        return "account-home";
//
//    }
//
//    @GetMapping("account/home/search")
//    public String searchAccount(Model model, @RequestParam String data) {
//        log.info("account/home/search");
//        model.addAttribute("listAccount", accountService.searchListAccount(data));
//        return "account-home";
//
//    }
//
//    @DeleteMapping("account/delete/{id}")
//    public String deleteAccount( @PathVariable Integer id,RedirectAttributes redirAttrs) {
//        log.info("account/delete/" + id);
//        boolean check = accountService.deleteAccount(id);
//        if (check){
//            redirAttrs.addFlashAttribute("success", "Xoá thành công!");
//            return "redirect:/admin/account/home";
//        }else {
//            redirAttrs.addFlashAttribute("error", "Xoá thất bại!");
//            return "redirect:/admin/account/home";
//        }
//
//    }
//
//    @GetMapping("account/add")
//    public String addAccount(Model model) {
//        log.info("account/add");
//        model.addAttribute("ListDepratment", departmentService.getListDepartment());
//        return "account-add";
//
//    }
//
//    @PostMapping("account/save")
//    public String saveAccount(@ModelAttribute  Account account) {
//        log.info("account/add " + account);
//        accountService.saveAccount(account);
//        return "redirect:/admin/account/home";
//
//    }
//
//    @GetMapping("account/edit/{id}")
//    public String editAccount(Model model, @PathVariable Integer id) {
//        log.info("account/edit/" + id);
//        model.addAttribute("account", accountService.updateAccount(id).get());
//        model.addAttribute("ListDepratment", departmentService.getListDepartment());
//        return "account-update";
//
//    }
//
//    @PostMapping("account/update")
//    public String updateAccount(@ModelAttribute Account account) {
//        log.info("account/update");
//        accountService.saveAccount(account);
//        return "redirect:/admin/account/home";
//
//    }


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
