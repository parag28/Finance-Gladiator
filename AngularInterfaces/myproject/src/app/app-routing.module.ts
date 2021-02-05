import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductinfoComponent} from './productinfo/productinfo.component';
import {ProductlistComponent} from './productlist/productlist.component';
import { DashBoardComponent} from './dash-board/dash-board.component';
const routes: Routes = [
    {path:'productinfo/:productid',component:ProductinfoComponent},
    {path:'productlist',component:ProductlistComponent},
    {path:'dashboard',component: DashBoardComponent}

    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
