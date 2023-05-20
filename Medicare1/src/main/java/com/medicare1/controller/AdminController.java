package com.medicare1.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare1.dto.AdminDto;
import com.medicare1.entity.Admin;
import com.medicare1.service.AdminService;



@SuppressWarnings("unused")
@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminController {
  @Autowired
  private AdminService adminService;
  
  @PostMapping("/add-admin")
  public String addAdmin(@RequestBody AdminDto adminDto) {
	  return adminService.addAdmin(adminDto);
  }
  
  @GetMapping("/getAll")
  public List<Admin> getAllAdmins(){
	  return adminService.getAllAdmin();
  }
}