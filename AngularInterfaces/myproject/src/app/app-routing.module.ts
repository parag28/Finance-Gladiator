import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductinfoComponent} from './productinfo/productinfo.component'
import {ProductlistComponent} from './productlist/productlist.component'
const routes: Routes = [
    {path:'productinfo/:productid',component:ProductinfoComponent},
    {path:'productlist',component:ProductlistComponent}

    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
