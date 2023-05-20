import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Medicine } from './medicine';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  baseUrl:string="http://localhost:8080/medicines"

  constructor(private http:HttpClient) { }

  getAllMedicines(){
    
    return this.http.get<Medicine[]>(this.baseUrl+"/getAll");
  }

  addMedicine(medicineData:Medicine){

    console.log("service" +medicineData)

     return    this.http.post(this.baseUrl+"/add-medicine",medicineData);


  }
  updateMedicine(medicine:Medicine){
    return this.http.put(this.baseUrl+"/updateMedicine",medicine);
  }

  getMedicineById(id:any){
    return this.http.get<any>(this.baseUrl+"/get-medicine/"+id)
  }
   
  deleteMedicineById(id:number){
    return this.http.delete(this.baseUrl+"/deleteMedicine/"+id)
  }

}
