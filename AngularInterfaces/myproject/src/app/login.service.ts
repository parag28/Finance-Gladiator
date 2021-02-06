import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Login} from './login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl: string = 'http://localhost:8080/';
  login:Login;
  constructor(private http:HttpClient) { }
  getAllLogins() :Observable<Login[]>
  { console.log("loginservice called");
    return this.http.get<Login[]>(this.baseUrl+"getAllLogins/");
  }

  getLoginsByUserName(username: string) :Observable<Login>{
    console.log("Hit in service login: method getLoginByUserName");
    return this.http.get<Login>(this.baseUrl+"getLogin/"+username);
  }
  updatelogin(login :Login) :Observable<string>{
    console.log("Hit in updateLogin");
    return this.http.post<string>(this.baseUrl+"updateLogin/",login);
  }
}
