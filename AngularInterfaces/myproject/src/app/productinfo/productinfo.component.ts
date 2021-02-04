import { Component, OnInit } from '@angular/core';
import{ActivatedRoute} from '@angular/router';
import { Subscription } from 'rxjs/internal/Subscription';
import { Product } from '../product';
import {Transaction} from '../transaction';
import { ProductService } from '../product.service';
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
  constructor(private actRoute:ActivatedRoute,private productService: ProductService) {}

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

    
  }

}
