import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product';
import {Login} from './login';

@Injectable({
  providedIn: 'root'
})
export class ChangepasswordService {
  baseUrl: string = 'http://localhost:8080/';
  constructor(private myhttp:HttpClient) { }
  updatePassword(login:Login){
    this.baseUrl="http://localhost:8080/updateLogin";
    console.log("Came to change password service");
    return this.myhttp.post<string>(this.baseUrl,login);
  }
}
