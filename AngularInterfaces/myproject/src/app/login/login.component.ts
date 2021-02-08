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
          if(this.fetchedLogin.username=="admin" && this.fetchedLogin.password=="admin"){
            this.router.navigate(['adminhome']);
          }
          else{
            this.router.navigate(['userhome']);
          }

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
