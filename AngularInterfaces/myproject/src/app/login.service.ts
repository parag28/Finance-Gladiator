import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product';
import {Login} from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl: string = 'http://localhost:8080/';
  login:Login={};
  constructor(private http:HttpClient) { }
  getLoginByUserName(username: string) :Observable<Login>{
    console.log("Hit in service login: method getLoginByUserName");
    return this.http.get<Login>(this.baseUrl+"getLogin/"+username);
  }
}
