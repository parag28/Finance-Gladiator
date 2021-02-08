import { Component, OnInit } from '@angular/core';
import {Login} from '../login';
import {LoginService} from '../login.service';
import {ProductService} from '../product.service';
import {Router} from '@angular/router';
import {Product} from '../product';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: any={};
  fetchedLogin:any={};
  constructor(private loginService: LoginService, private router: Router) {
  }


  ngOnInit(): void {
  }
  loginFunction(){
    this.loginService.getLoginByUserName(this.login.username).subscribe((data: Login)=>
    {
      if(this.login.username=="admin" && this.login.password=="admin"){
        this.router.navigate(['adminhome']);
        return;
      }
      this.fetchedLogin = data;
      if(this.fetchedLogin.username!="erroruser" ){
        if(this.fetchedLogin.userApprovalStatus==0){
          alert("The Admin hasn't Approved your Candidature Yet, Please visit Soon");
          return null;
        }
        if(this.fetchedLogin.userApprovalStatus==-1){
          alert("The Admin Rejected your candidature. Please apply again");
          return null;
        }
        if(this.fetchedLogin.password==this.login.password){
          localStorage.setItem("localVariableUserName",this.login.username);
            this.router.navigate(['userhome']);

        }
        else{
          alert("Invalid Credentials, Retry");
        }
      }
      else{
        alert("Invalid Credentials, Retry");
      }
    },(err)=>{
    });

  }
}
