import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Purchase } from './purchase';

@Injectable({
  providedIn: 'root'
})


export class OrderService {

  private _tempurl =  'http://localhost:8080/';
      private _url =      'http://localhost:8080/';

  constructor(private _http : HttpClient) { }

  getOrders(userName:string)
  {
     this._url = this._tempurl;
     this._url += 'getAllUserOrders/'+userName;
     return this._http.get<Purchase>(this._url);
  }
}
