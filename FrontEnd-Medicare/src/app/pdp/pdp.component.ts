import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Medicine } from '../medicine';
import { MedicineService } from '../medicine.service';

@Component({
  selector: 'app-pdp',
  templateUrl: './pdp.component.html',
  styleUrls: ['./pdp.component.css'],
})
export class PdpComponent implements OnInit {
  medicineList: Medicine[] = [];

  constructor(private mservice: MedicineService, private route: Router) {}

  ngOnInit(): void {
    this.mservice.getAllMedicines().subscribe((res) => {
      console.log(res);
      res.forEach((data) => {
        console.log(data);
        this.medicineList.push(data);
      });
    });
  }

  getProductsTable() {
    this.mservice.getAllMedicines().subscribe((res) => {
      console.log(res);

      res.forEach((data) => {
        console.log(data);

        this.medicineList.push(data);
      });
    });
  }
  updateMedicine(id: number) {
    alert(id + ' medicine will Update');
    this.route.navigate(['update-medicine', id]);
  }

  deleteMedicine(id: number) {
    // alert("product "+id+" will be deleted")
    this.mservice.deleteMedicineById(id).subscribe(
      (res) => {
        if (res) alert(id + ' Deleted');
      },
      (err) => {
        alert(id + ' Deleted');
      }
    );
  }

  bulk() {
    this.route.navigate(['bulk-upload']);
  }
}
