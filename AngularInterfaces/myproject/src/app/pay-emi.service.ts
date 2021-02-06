import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class PayEMIService {
  baseUrl: string = 'http://localhost:8080/';
  constructor(private myhttp:HttpClient) { }
  getPayEmi(Emiid:number) :Observable<string>
  {
    console.log("GetPayEmi called");
    return this.myhttp.get<string>(this.baseUrl+"payEmi/"+Emiid);
  }
}
