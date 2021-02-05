import { Component, OnInit } from '@angular/core';
import {FormControl, Validators,} from '@angular/forms';
import { Register } from '../DTO1/register.dto';
import { Router } from '@angular/router';
import { RegisterService } from '../register.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
// 
export class RegisterComponent implements OnInit {

  user= new Register;
  bankNames= ["Allahabad Bank","Axis Bank","Bank of Maharahtra","Bank of Baroda",
  "Central Bank","HDFC Bank","ICICI Bank","Indian Bank","Metro Multistate",
  "Punjab National Bank","RBL Bank","State Bank of India","Union Bank of India","Yes Bank"];
  
  cards=[{label: "Gold", value: 0}, {label: "Platinum", value: 1}]

  constructor(private _registerService: RegisterService,private _router : Router) { 
    this.user=new Register();
  }


  ngOnInit(): void {
    
  }
  isPassEqual=true;

  checkPassword(): void {
    console.log(this.user)
    this.isPassEqual= this.user.password===this.user.confirm_password;
  }

  

  // onRegister(){
  //   console.log(this.user);
  // }

  
  onCardTypeSelectionChange(entry: number): void {
    this.user.cardType = entry;
}

  onRegisterClick()
  {
    this._registerService.addNewUser(this.user)
    .subscribe(data=>
      {
        if(data == -100)
        { 
          alert("User Already Registered");
        }
        else
        {
          alert("Congratulations! You are registered. Please Login :) ");
          this._router.navigate(['login']);
        }
      });

  }


}
