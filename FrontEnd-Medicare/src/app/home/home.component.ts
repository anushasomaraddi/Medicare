import { Component } from '@angular/core';
import { Medicine } from '../medicine';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  medicines: Medicine[]=[]
  searchText:any
  pid:any

  constructor(private mservice:MedicineService) { }

  ngOnInit(): void {
    this.mservice.getAllMedicines().subscribe(res=>{
      this.medicines=res
    })
  }
  getData(){
    alert("Login first")

  }

}
