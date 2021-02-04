import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  constructor() { }

  user={
    fullname:"",
    dob:"",
    email:"",
    bankname:"",
    username:"",
    accountno:"",
    ifsc:"",
    phoneno:"",
    password:"",
    confirm_password:"",
    address:""
  }

  isPassEqual=true;

  ngOnInit(): void {
  }

  checkPassword(value: string): void {
    console.log(value)
    this.isPassEqual= this.user.password===this.user.confirm_password;
  }

  


}
