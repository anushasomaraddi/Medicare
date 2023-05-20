package com.medicare1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medicare1.dto.MedicineDto;
import com.medicare1.entity.Medicine;
import com.medicare1.helper.Helper;
import com.medicare1.service.MedicineService;

@RestController
@RequestMapping("/medicine")
@CrossOrigin("http://localhost:4200/")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@PostMapping("/add-medicine")
	public String addMedicine(@RequestBody MedicineDto dto) {
		return medicineService.addMedicines(dto);
		
	}
	
	@GetMapping("/getAll")
	public List<Medicine> getAllMedicine(){
		return medicineService.getAllMedicines();
	}
	
	@PutMapping("/updateMedicine")
	public String updateMedicine(@RequestBody MedicineDto dto) {
		return medicineService.updateMedicines(dto);
	}
	
	@DeleteMapping("/deleteMedicine/{id}")
	public String deleteMedicine(@PathVariable long id) {
		return medicineService.deleteMedicines(id);
	}
	
	@GetMapping("get-medicine/{id}")
	public Medicine getMedicineById(@PathVariable long id) {
		return medicineService.getMedicineById(id);

	
}
	@PostMapping("/add-bulk-medicine")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExelFormat(file))
		{
			this.medicineService.saveMultiple(file);
			return ResponseEntity.ok(Map.of("message","file is uploaded"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file only");
		
	}
	@GetMapping("/get-sorted-medicine")
	public List<Medicine> getSortedMedicine(){
		return medicineService.getSortedMedicine();
	}

}
