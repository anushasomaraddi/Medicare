import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../cart.service';
import { Medicine } from '../medicine';
import { MedicineService } from '../medicine.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit{

  medicines: Medicine[]=[]
  searchText:any
  
  


  constructor(private mservice:MedicineService,private uservice:UserService,private router:ActivatedRoute,private rout:Router,private cservice:CartService) { }
u_id:any
p_id:any

  ngOnInit(): void {

    this.u_id=this.router.snapshot.paramMap.get('id')
    // alert("welcome user "+this.u_id)

    //to show products in user page
    this.mservice.getAllMedicines().subscribe(res=>{
      this.medicines=res

    })



  }


  

  addCartData(pid:number){
    this.p_id=pid
    this.cservice.addToCart(pid,this.u_id).subscribe(res=>{
      alert("item added to cart")
    });

  }

  userLogout(){
    localStorage.setItem('token','')
  }

  getCartData(){
    this.rout.navigate(['cart',this.u_id])

  }

  


}
