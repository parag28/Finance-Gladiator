import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { ApproveuserService } from '../approveuser.service';
import { Login } from '../login';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-adminpage',
  templateUrl:'./adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {
 // userName: string |null = localStorage.getItem("localVariableUserName");
 userName:string="bindu19";
  private subscription: Subscription;
  user: User;
  UsersList: User[];
  UsersListDisplay: User[][];
  result:string;
login:Login;

  constructor(private approveuserService: ApproveuserService,private loginService: LoginService, private router: Router ) { }

  ngOnInit(): void {
    this.subscription = this.approveuserService.getUsersByUserName(this.userName).subscribe((data: User ) => {
      this.user = data;
      console.log("userlist checking");
      console.log(this.user);
      }, (err: any) => {
       console.log(err);
     });
  }

  
  function(){
    let subscription= this.loginService.getLoginsByUserName(this.userName).subscribe((data: Login)=>{
      this.login=data;
      this.login.userapprovalstatus=1;
      this.loginService.updatelogin(this.login).subscribe((data:string)=>{
        this.result=data;
      });
    }, (err: any) => {
      console.log(err);
    
    });
      this.loginService.updatelogin(this.login).subscribe((data:string)=>{
        this.result=data;
      }, (err: any) => {
        console.log(err);
    });
  }



}