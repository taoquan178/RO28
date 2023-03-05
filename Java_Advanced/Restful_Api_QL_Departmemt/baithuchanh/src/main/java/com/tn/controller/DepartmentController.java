package com.tn.controller;

import com.tn.dto.AccountDTO;
import com.tn.dto.DepartmentDTO;
import com.tn.entity.Department;
import com.tn.from.FromCreateDepartment;
import com.tn.from.FromUpdateDepartment;
import com.tn.service.IDepartmentService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController
//@Controller
@Data
@RequestMapping("department")
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<?> getPage(Pageable pageable) {
//        Pageable pageable = PageRequest.of(page,size);
        Page<DepartmentDTO> dtoPage  = departmentService.getPageDepartment(pageable);
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping("getall")
    public ResponseEntity<?> getAll() {
//        Pageable pageable = PageRequest.of(page,size);
        List<DepartmentDTO> departmentDTOs  = departmentService.getAllDepartment();
        return new ResponseEntity<>(departmentDTOs, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getDepartment(@PathVariable Integer id) {
        DepartmentDTO departmentDTO = modelMapper.map(departmentService.getDepartmentById(id),DepartmentDTO.class);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }

    @GetMapping("{name}/exist")
    public ResponseEntity<?> existDepartmentName(@PathVariable String name) {
        return new ResponseEntity<>(departmentService.existsDepartmentName(name), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addDepartment(@RequestBody FromCreateDepartment fromCreateDepartment){
        Department department = departmentService.saveDepartment(fromCreateDepartment);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Integer id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping("deletelist")
    public ResponseEntity<?> deleteListDepartment(@RequestParam(name = "ids") List<Integer> ids){
        departmentService.deleteListDepartment(ids);
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Integer id, @RequestBody FromUpdateDepartment fromUpdateDepartment){
        departmentService.updateDepartment(id,fromUpdateDepartment);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<?> departmentSearch(@RequestParam String data, Pageable pageable) {
        return new ResponseEntity<>(departmentService.searchListDepartment(data,pageable), HttpStatus.OK);

    }

//    @GetMapping("department/home")
//    public String departmentHome(Model model) {
//        log.info("department/home");
//        model.addAttribute("ListDepratment",departmentService.getListDepartment());
//        return "department-home";
//
//    }
//
//    @GetMapping("department/home/search")
//    public String departmentSearch(Model model,@RequestParam String data) {
//        log.info("department/home/search");
//        model.addAttribute("ListDepratment",departmentService.searchListDepartment(data));
//        return "department-home";
//
//    }
//
//    @GetMapping("department/add")
//    public String addDepartment(){
//        log.info("department/add");
//        return "department-add";
//    }
//
//    @PostMapping("department/save")
//    public String saveDepartment(@ModelAttribute Department department){
//        log.info("department/save "+department);
//        departmentService.saveDepartment(department);
//        return "redirect:/admin/department/home";
//
//    }
//
//    @GetMapping("department/edit/{id}")
//    public String editDepartment(Model model, @PathVariable Integer id){
//        log.info("department/edit/"+id);
//        model.addAttribute("department",departmentService.updateDepartment(id).get());
//        return "department-update";
//
//    }
//
//    @PostMapping("department/update")
//    public String updateDepartment(@ModelAttribute Department department){
//        log.info("department/update");
//        departmentService.saveDepartment(department);
//        return "redirect:/admin/department/home";
//
//    }
//
//    @GetMapping("department/delete/{id}")
//    public String deleteDepartment(@PathVariable Integer id){
//        log.info("department/delete/"+id);
//        departmentService.deleteDepartment(id);
//        return "redirect:/admin/department/home";
//    }

}
