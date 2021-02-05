import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Purchaseproductdto} from './purchaseproductdto';
@Injectable({
  providedIn: 'root'
})
export class PurchaseproductdtoService {
  baseUrl: string = 'http://localhost:8080/';
  constructor(private myhttp:HttpClient) { }
  AddPurchaseProduct(purchaseproduct: Purchaseproductdto) :Observable<Purchaseproductdto>
  { console.log("purchaseproductservice called");
    return this.myhttp.post<Purchaseproductdto>(this.baseUrl+"purchaseProduct/",purchaseproduct);
  }
}
