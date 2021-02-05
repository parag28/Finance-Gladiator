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

  login: Login;
  fetchedLogin: Login;
  constructor(private loginService: LoginService, private router: Router) {
  }


  ngOnInit(): void {
  }
  loginFunction(){
    this.loginService.getLoginByUserName(this.login.username).subscribe((data: Login)=>
    {
      this.fetchedLogin = data;
      if(this.fetchedLogin.username!="erroruser"){
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
