import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CustomValidators} from '../custom-validators';
import {ChangepasswordService} from '../changepassword.service';
import {LoginService} from '../login.service';
import {Login} from '../login';
import {Observable} from 'rxjs';
import {Product} from '../product';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent implements OnInit {
  userName: any;
  newPassword: string;
  public frmSignup: FormGroup;
  login:Login;
  constructor(private fb: FormBuilder, private service: ChangepasswordService, private loginService:LoginService) {
    this.frmSignup = this.createSignupForm();
  }
  createSignupForm(): FormGroup {
    return this.fb.group(
      {
        password: [
          null,
          Validators.compose([
            Validators.required,
            Validators.minLength(4)
          ])
        ],
        confirmPassword: [null, Validators.compose([Validators.required])]
      },
      {
        // check whether our password and confirm password match
        validator: CustomValidators.passwordMatchValidator
      }
    );
  }

  submit() {
    this.loginService.getLoginByUserName(this.userName).subscribe((data: Login) => {
      this.login = data;
      console.log(this.login);
      this.newPassword = this.frmSignup.value.password;
      this.login.password = this.newPassword;
      console.log(this.login);
      this.service.updatePassword(this.login).subscribe((data:string) =>{
        console.log("Got into the loop");
        console.log(data);
      });
    }, (err) => {
      console.log(err);
    });

  }
  ngOnInit(): void {
  }

}
