package com.tn.controller;

import com.tn.entity.Account;
import com.tn.entity.Department;
import com.tn.repository.IAccountRepository;
import com.tn.repository.IDepartmentRepository;
import com.tn.service.IDepartmentService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        log.info("department/home");
        model.addAttribute("ListDepratment",departmentService.getListDepartment());
        return "department-home";

    }

    @GetMapping("department/home/search")
    public String departmentSearch(Model model,@RequestParam String data) {
        log.info("department/home/search");
        model.addAttribute("ListDepratment",departmentService.searchListDepartment(data));
        return "department-home";

    }

    @GetMapping("department/add")
    public String addDepartment(){
        log.info("department/add");
        return "department-add";
    }

    @PostMapping("department/save")
    public String saveDepartment(@ModelAttribute Department department){
        log.info("department/save "+department);
        departmentService.saveDepartment(department);
        return "redirect:/admin/department/home";

    }

    @GetMapping("department/edit/{id}")
    public String editDepartment(Model model, @PathVariable Integer id){
        log.info("department/edit/"+id);
        model.addAttribute("department",departmentService.updateDepartment(id).get());
        return "department-update";

    }

    @PostMapping("department/update")
    public String updateDepartment(@ModelAttribute Department department){
        log.info("department/update");
        departmentService.saveDepartment(department);
        return "redirect:/admin/department/home";

    }

    @GetMapping("department/delete/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        log.info("department/delete/"+id);
        departmentService.deleteDepartment(id);
        return "redirect:/admin/department/home";
    }

}
