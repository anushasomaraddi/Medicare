package com.medicare1.service;

import java.util.List;

import com.medicare1.dto.AdminDto;
import com.medicare1.entity.Admin;

public interface AdminService {
	
	public String addAdmin(AdminDto adminDto);
	
	public List<Admin> getAllAdmin();

}
