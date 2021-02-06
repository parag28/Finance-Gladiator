import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrderService } from '../order.service';
import { Subscription } from 'rxjs';
import { Purchase } from '../purchase';


const dummyPurchases = [{
  purchaseId : 984,
  product: {
    productName: "testName1",
    price: 100
  },
  purchaseDate: "19/08/2002"
},{
  purchaseId : 985,
  purchaseDate: "12/07/2002",
  product: {
    productName: "testName2",
    price: 200
  }
}]
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit {
  userName: string  |null= localStorage.getItem("localVariableUserName");
  private subscription: Subscription;
  purchase = dummyPurchases; //comment this if the table is not empty

  constructor(private _orderService: OrderService, private router: Router) {  }


  ngOnInit(): void {
    this.subscription=this._orderService.getOrders(this.userName)
    .subscribe((data : Purchase)=>{
       this.purchase = data;      //un-comment this if the table is not empty
      console.log(this.purchase);
    }, (err : any) =>{
      console.log(err);
    });
  }



}
