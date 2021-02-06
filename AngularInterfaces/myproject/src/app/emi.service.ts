import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Emi} from './emi';
@Injectable({
  providedIn: 'root'
})
export class EmiService {

  baseUrl: string = 'http://localhost:8080/';
  constructor(private myhttp:HttpClient) { }
  getAllEmis() :Observable<Emi[]>
  {
    console.log("AllEmis called");
    return this.myhttp.get<Emi[]>(this.baseUrl+"getAllEMIs/");
  }
}
