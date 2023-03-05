package com.tn.controller;

import com.tn.dto.LoginInfoDTO;
import com.tn.entity.Account;
import com.tn.service.IAccountService;
import com.tn.service.IDepartmentService;
import com.tn.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> infoLogin(Principal principal){
        String userName = principal.getName();
        Account entity = userService.getAccountByUsername(userName);
        LoginInfoDTO dto = modelMapper.map(entity,LoginInfoDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
