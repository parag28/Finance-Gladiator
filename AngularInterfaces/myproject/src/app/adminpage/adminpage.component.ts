import { Component, OnInit } from '@angular/core';
import {Login} from '../login';
import {Emi} from '../emi';
import {Subscription} from 'rxjs/internal/Subscription';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-adminpage',
  templateUrl: './adminpage.component.html',
  styleUrls: ['./adminpage.component.css']
})
export class AdminpageComponent implements OnInit {
  private subscription: Subscription;
  constructor(private loginService:LoginService, private router:Router) { }
  logins:Login[];
  ngOnInit(): void {
    this.subscription = this.loginService.getAllLogins().subscribe((data: Emi[]) => {
      this.logins = data;
      console.log(this.logins);
    }, (err) => {
      console.log(err);
    });
  }
  approveUser(userName:string){
    this.loginService.approveUser(userName);
    location.reload();
  }
  declineUser(userName:string){
    this.loginService.declineUser(userName);
    location.reload();
  }
}

