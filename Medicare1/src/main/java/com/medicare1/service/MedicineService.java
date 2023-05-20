package com.medicare1.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.medicare1.dto.MedicineDto;
import com.medicare1.entity.Medicine;

public interface MedicineService {
	
	public String addMedicines(MedicineDto medicineDto);
	
	public List<Medicine> getAllMedicines();
	
	public String updateMedicines(MedicineDto medicineDto);
	
	public String deleteMedicines(Long id);
	
	public Medicine getMedicineById(long id);
	
	 public void saveMultiple(MultipartFile file); 
	
	public List<Medicine> getSortedMedicine();

}
