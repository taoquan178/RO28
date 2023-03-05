package com.tn.controller;

import com.tn.entity.Account;
import com.tn.entity.Department;
import com.tn.repository.IAccountRepository;
import com.tn.repository.IDepartmentRepository;
import com.tn.service.IDepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@Data
@RequestMapping("admin")
@Slf4j
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("department/home")
    public String departmentHome(Model model) {
        try {
            log.info("department/home");
            model.addAttribute("ListDepratment",departmentService.getListDepartment());
            return "department-home";
        }catch (Exception e){
            log.error("department/home"+" False");
            model.addAttribute("error","Truy cập không thành công! "+ e.getMessage());
            return "error";
        }
    }

    @GetMapping("department/home/search")
    public String departmentSearch(Model model,@RequestParam String data) {
        try {
            log.info("department/home/search");
            model.addAttribute("ListDepratment",departmentService.searchListDepartment(data));
            return "department-home";
        }catch (Exception e){
            log.error("department/home/search"+" False");
            return "error"+ e.getMessage();
        }
    }

    @GetMapping("department/add")
    public String addDepartment(){
        try {
            log.info("department/add");
            return "department-add";
        }catch (Exception e){
            log.error("department/add"+" False");
            return "error"+ e.getMessage();
        }
    }

    @PostMapping("department/save")
    public String saveDepartment(@ModelAttribute Department department,Model model,RedirectAttributes redirAttrs){
        try {
            log.info("department/save "+department);
            departmentService.saveDepartment(department);
            redirAttrs.addFlashAttribute("success", "Thêm thành công!");
            return "redirect:/admin/department/home";
        }catch (Exception e){
            log.error("department/save "+department +" False");
            model.addAttribute("error", "Thêm không thành công"+e.getMessage());
            return "error";
        }
    }

    @GetMapping("department/edit/{id}")
    public String editDepartment(Model model, @PathVariable Integer id){
        try {
            log.info("department/edit/"+id);
            model.addAttribute("department",departmentService.updateDepartment(id).get());
            return "department-update";
        }catch (Exception e){
            log.error("department/edit/"+id+" False");
            return "error"+ e.getMessage();
        }
    }

    @PostMapping("department/update")
    public String updateDepartment(@ModelAttribute Department department,Model model,RedirectAttributes redirAttrs){
        try {
            log.info("department/update");
            departmentService.saveDepartment(department);
            redirAttrs.addFlashAttribute("success", "Cập nhập thành công!");
            return "redirect:/admin/department/home";
        }catch (Exception e){
            log.error("department/update"+" False");
            model.addAttribute("error", "Cập nhập không thành công! "+e.getMessage());
            return "error";
        }
    }

    @GetMapping("department/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id, RedirectAttributes redirAttrs){
        try {
            log.info("department/delete/"+id);
            boolean check = departmentService.deleteDepartment(id);
            if (check){
                redirAttrs.addFlashAttribute("success", "Xoá thành công!");
                return "redirect:/admin/department/home";
            } else {
                redirAttrs.addFlashAttribute("error", "Xoá thất bại!");
                return "redirect:/admin/department/home";

            }

        }catch (Exception e){
            log.error("department/delete/"+id+" False");
            return "error"+ e.getMessage();
        }
    }

}
