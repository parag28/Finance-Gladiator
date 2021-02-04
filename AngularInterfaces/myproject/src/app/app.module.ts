import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductinfoComponent } from './productinfo/productinfo.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {AdminpageComponent} from './adminpage/adminpage.component';
import { HomepageComponent } from './homepage/homepage.component';
import {DashBoardComponent} from './dash-board/dash-board.component';
import {VerifyComponent} from './verify/verify.component';
import {ProductlistComponent} from './productlist/productlist.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {ReactiveFormsModule} from '@angular/forms';
@NgModule({
    declarations: [
        AppComponent,
        ProductinfoComponent,
        ForgotPasswordComponent,
        ChangePasswordComponent,
        LoginComponent,
        RegisterComponent,
        AdminpageComponent,
        HomepageComponent,
        DashBoardComponent,
        VerifyComponent,
        ProductlistComponent 
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
