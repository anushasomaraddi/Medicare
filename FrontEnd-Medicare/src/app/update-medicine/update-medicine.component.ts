import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Medicine } from '../medicine';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-update-medicine',
  templateUrl: './update-medicine.component.html',
  styleUrls: ['./update-medicine.component.css']
})
export class UpdateMedicineComponent implements OnInit{

  medicineToUpdate:Medicine={
    id: 0,
    name: '',
    price: 0,
    url: '',
    quantity: 0,
    category: ''
  }
id:any
  constructor(private mservice:MedicineService,private route:ActivatedRoute) { }


  ngOnInit(): void {
    this.id=this.route.snapshot.paramMap.get('id')
    this.mservice.getMedicineById(this.id).subscribe(res=>{
      this.medicineToUpdate=res
      // alert(this.id+" will be Update")
    })
  }

  editMedicine(data:Medicine){
    this.medicineToUpdate=data
    this.medicineToUpdate.id=this.id
    
    this.mservice.updateMedicine(this.medicineToUpdate).subscribe(res=>{
      alert("Data updated")
  
    },
    (err) =>{
  
      alert("Data updated")
  
  
    }
    )
}

}
