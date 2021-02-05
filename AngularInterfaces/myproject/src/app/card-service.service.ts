import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product';
import {Card} from './card';

@Injectable({
  providedIn: 'root'
})
export class CardServiceService {

  baseUrl: string = 'http://localhost:8080/';
  constructor(private myhttp:HttpClient) { }
  getCardByUserName(userName:string) :Observable<Card>
  {
    console.log("Card by Uname called"+userName);
    return this.myhttp.get<Card>(this.baseUrl+"getCard/" + userName);
  }
}
