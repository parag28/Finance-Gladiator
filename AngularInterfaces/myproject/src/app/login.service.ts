import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Product} from './product';
import {Login} from './login';
import {Emi} from './emi';
import {Subscription} from 'rxjs/internal/Subscription';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl: string = 'http://localhost:8080/';
  login:Login;
  tempLogin:Login;
  private subscription:Subscription;
  private subscription2:Subscription;
  constructor(private http:HttpClient) { }
  getLoginByUserName(username: string) :Observable<Login>{
    console.log("Hit in service login: method getLoginByUserName");
    return this.http.get<Login>(this.baseUrl+"getLogin/"+username);
  }
  getAllLogins():Observable<Login[]>{
    console.log("hit the get all logins method");
    return this.http.get<Login[]>(this.baseUrl+"getAllLogin");
  }
  updateLogin(login:Login):Observable<string>{
    return this.http.post<string>(this.baseUrl+"updateLogin",login);
  }
  approveUser(userName:string):void{
    console.log("Hit approve User");
    this.subscription = this.getLoginByUserName(userName).subscribe((data: Login) => {
      this.tempLogin = data;
      console.log(this.tempLogin);
      this.tempLogin.userApprovalStatus = 1;
      console.log(this.tempLogin);
      console.log(this.baseUrl+"updateLogin", this.tempLogin);
      this.subscription2 = this.updateLogin(this.tempLogin).subscribe((data:string)=>{
        console.log(data);
      });

    }, (err) => {
      console.log(err);
    });


  }


  declineUser(userName:string):void{
    console.log("Hit decline User");
    this.subscription = this.getLoginByUserName(userName).subscribe((data: Login) => {
      this.tempLogin = data;
      console.log(this.tempLogin);
      this.tempLogin.userApprovalStatus = -1;
      console.log(this.tempLogin);
      console.log(this.baseUrl+"updateLogin", this.tempLogin);
      this.subscription2 = this.updateLogin(this.tempLogin).subscribe((data:string)=>{
        console.log(data);
      });

    }, (err) => {
      console.log(err);
    });
  }


}
