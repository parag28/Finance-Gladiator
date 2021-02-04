import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';

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
        DashBoardComponent
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
