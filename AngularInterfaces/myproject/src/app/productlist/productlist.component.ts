import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/internal/Subscription';
import { Product } from '../product';
import {Transaction} from '../transaction';
import { ProductService } from '../product.service';
import {Router } from '@angular/router';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {
  userName: any= localStorage.getItem("localVariableUserName");
  private subscription: Subscription;
  productList: Product[];
  productListDisplay: Product[][];
  product: Product;


  constructor(private productService: ProductService, private router: Router ) { }
  ngOnInit(): void {

    this.subscription = this.productService.getAllProducts().subscribe((data: Product[]) => {
      this.productList = data;
      }, (err) => {
       console.log(err);
     });
  }


getProductById(productid: number){
    this.productService.getProductById(productid).subscribe((data: Product) => {
      this.product = data;
      console.log("Hello");
      console.log(this.product);
      }, (err) => {
      console.log(err);
    });
  }

navigate(productid: number){
    this.router.navigate(['productinfo', productid]);
  }
  navigate1(){
    this.router.navigate(["productlist"]);
  }
  navigate2(){
    this.router.navigate(["userhome"]);
  }

}
