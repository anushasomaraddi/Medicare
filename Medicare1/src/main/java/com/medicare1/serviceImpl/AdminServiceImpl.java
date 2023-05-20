package com.medicare1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare1.dto.AdminDto;
import com.medicare1.entity.Admin;
import com.medicare1.repository.AdminRepository;
import com.medicare1.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public String addAdmin(AdminDto adminDto) {
		// TODO Auto-generated method stub
		
		Admin admin=new Admin();
		admin.setEmail(adminDto.getEmail());
		admin.setPassword(adminDto.getPassword());
		adminRepository.save(admin);
			return "New Admin data saved";
		
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	
}
