import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductinfoComponent} from './productinfo/productinfo.component';
import {ProductlistComponent} from './productlist/productlist.component';
import {HomepageComponent} from './homepage/homepage.component';
import {Login} from './login';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {ForgotPasswordComponent} from './forgot-password/forgot-password.component';
import {ChangePasswordComponent} from './change-password/change-password.component';
import {AdminpageComponent} from './adminpage/adminpage.component';
import {DashBoardComponent} from './dash-board/dash-board.component';
import {EmisComponent} from './emis/emis.component';
import {OrdersComponent} from './orders/orders.component';
import {TransactionsComponent} from './transactions/transactions.component'


const routes: Routes = [
  {path: '', component: HomepageComponent},
  {path: 'productinfo/:productid', component: ProductinfoComponent},
  {path: 'productlist', component: ProductlistComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'forgotpassword', component: ForgotPasswordComponent},
  {path: 'changepassword', component: ChangePasswordComponent},
  {path: 'adminhome', component: AdminpageComponent},
  {path: 'userhome', component: DashBoardComponent},
  {path: 'emis', component: EmisComponent},
  {path: 'orders', component: OrdersComponent},
  {path: 'transactions', component: TransactionsComponent}

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
