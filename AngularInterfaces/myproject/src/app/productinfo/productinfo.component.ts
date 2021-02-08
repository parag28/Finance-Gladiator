import { Component, OnInit } from '@angular/core';
import{ActivatedRoute} from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { Product } from '../product';
import {Transaction} from '../transaction';
import { ProductService } from '../product.service';
import {Router } from '@angular/router';
import {FormGroup,FormControl,Validators} from '@angular/forms';
import {Purchaseproductdto} from '../purchaseproductdto';
import {PurchaseproductdtoService} from '../purchaseproductdto.service';
import {Card} from '../card';
import{CardServiceService} from '../card-service.service';
@Component({
  selector: 'app-productinfo',
  templateUrl: './productinfo.component.html',
  styleUrls: ['./productinfo.component.css']
})
export class ProductinfoComponent implements OnInit {
subs:any;
productid:number;
private subscription: Subscription;
product:Product;
PeriodList=[3,6,9];
message :string="PAYMENT SUCCESSFULL";
userName: any = localStorage.getItem("localVariableUserName");
card:Card;
purchaseProd:Purchaseproductdto;
  constructor(private actRoute:ActivatedRoute,private productService: ProductService,private router:Router,private purchaseproductService:PurchaseproductdtoService,private cardservice:CardServiceService) {}

  ngOnInit(): void {
    this.subs=this.actRoute.paramMap.subscribe(params=>{
      console.log(params);
      this.productid=Number(params.get('productid'));
      this.productService.getProductById(this.productid).subscribe((data: Product) => {
        console.log("productobject is fetched by id");
        console.log(this.product);
        this.product = data;
        }, (err) => {
        console.log(err);
      });
    });

    this.cardservice.getCardByUserName(this.userName).subscribe((data: Card) => {
      console.log("card object is fetched by userName");
      console.log(this.card);
      this.card = data;
      }, (err) => {
      console.log(err);
    });
  }
  PaymentForm=new FormGroup({
    productId:new FormControl(''),
    userName:new FormControl(''),
    quantity:new FormControl('',[Validators.required]),
    numberOfEmis:new FormControl('',[Validators.required]),


  })
  navigate(numberofproducts:number,productprice:number){
    if(this.PaymentForm.get("quantity")?.value<0){
      alert("Invalid Quantity!!");
    }
    else{
      if(this.PaymentForm.get("quantity")?.value>numberofproducts){
        alert("Quantity is more than Max Available:"+numberofproducts);
  
      }
    
    else{
      if(this.card.creditremaining<(productprice*this.PaymentForm.get("quantity")?.value)){
        alert("Enough Credit Not available");
  
      }
    else{
    if(window.confirm("Payment Confirmation!!")){
      this.PaymentForm.patchValue({
        productId : this.productid,
        userName :this.userName
      })
      
      this.purchaseProd=this.PaymentForm.value;
      this.purchaseproductService.AddPurchaseProduct(this.purchaseProd).subscribe(()=>console.log("PurchaseProduct added"));


      this.router.navigate(["paymentsuccess"]);}
    }    
  }
  }
}
}
