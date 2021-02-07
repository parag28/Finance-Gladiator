import { Component, OnInit } from '@angular/core';
import {Card} from '../card';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';
import {CardServiceService} from '../card-service.service';
import {PayEMIService} from '../pay-emi.service';

import {Subscription} from 'rxjs/internal/Subscription';
import {Emi} from '../emi';
import {EmiService } from '../emi.service';
@Component({
  selector: 'app-emis',
  templateUrl: './emis.component.html',
  styleUrls: ['./emis.component.css']
})
export class EmisComponent implements OnInit {
  userName: any = localStorage.getItem("localVariableUserName");
  private subscription: Subscription;
  EmiList:Emi[];
  result:string;


  constructor(private emiservice:EmiService,private router: Router,private payemiservice:PayEMIService) {
  }

  ngOnInit(): void {

    this.subscription = this.emiservice.getAllEmis(this.userName).subscribe((data: Emi[]) => {
      this.EmiList = data;
      }, (err) => {
       console.log(err);
     });

  }
  navigate(emiId:number){
     this.payemiservice.getPayEmi(emiId).subscribe((data: string) => {

      this.result=data;
      }, (err) => {
       console.log(err);
     });
    this.router.navigate(['paymentsuccess']);

  }

}
