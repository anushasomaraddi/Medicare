package com.medicare1.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medicare1.dto.MedicineDto;
import com.medicare1.entity.Medicine;
import com.medicare1.helper.Helper;
import com.medicare1.repository.MedicineRepository;
import com.medicare1.service.MedicineService;


@Service
public class MedicineServiceImpl implements MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;

	@Override
	public String addMedicines(MedicineDto medicineDto) {
		
		Medicine medicine = new Medicine();
		medicine.setName(medicineDto.getName());
		medicine.setPrice(medicineDto.getPrice());
		medicine.setUrl(medicineDto.getUrl());
		medicine.setQuantity(medicineDto.getQuantity());
		medicine.setCategory(medicineDto.getCategory());
		medicineRepository.save(medicine);
		
		return "New Product Is Saved";
	}

	@Override
	public List<Medicine> getAllMedicines() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	@Override
	public String updateMedicines(MedicineDto medicineDto) {
		// TODO Auto-generated method stub
		Medicine medicine=new Medicine();
		medicine.setId(medicineDto.getId());
		medicine.setName(medicineDto.getName());
		medicine.setPrice(medicineDto.getPrice());
		medicine.setUrl(medicineDto.getUrl());
		medicine.setQuantity(medicineDto.getQuantity());
		medicine.setCategory(medicineDto.getCategory());
		medicineRepository.save(medicine);
		return "Medicine is Updated";
	}

	@Override
	public String deleteMedicines(Long id) {
		// TODO Auto-generated method stub
		medicineRepository.deleteById(id);
		return "Medicine is Deleted";
	}

	@Override
	public Medicine getMedicineById(long id) {
		// TODO Auto-generated method stub
		return medicineRepository.findById(id).get();
	}

	@Override
	public List<Medicine> getSortedMedicine() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll(Sort.by("category"));
	}

	@Override
	public void saveMultiple(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			List<Medicine> medicine= Helper.convertExcelToListOfMedicine(file.getInputStream());
			this.medicineRepository.saveAll(medicine);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	
}
