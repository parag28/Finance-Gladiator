import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Product} from './product';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseUrl: string = 'http://localhost:8080/';
  constructor(private myhttp:HttpClient) { }
  getAllProducts() :Observable<Product[]>
  { console.log("productservice called");
    return this.myhttp.get<Product[]>(this.baseUrl+"getAllProducts/");
  }
  getProductById(productid :number) :Observable<Product>
  {
    console.log("productById service is called");
    return this.myhttp.get<Product>(this.baseUrl+"getProduct/" + productid);
    
    
  }
}
