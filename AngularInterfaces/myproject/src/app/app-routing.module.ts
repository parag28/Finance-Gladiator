import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductlistComponent} from './productlist/productlist.component';

const routes: Routes = [];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    declarations: [
        ProductlistComponent
    ],
    exports: [RouterModule, ProductlistComponent]
})
export class AppRoutingModule { }
