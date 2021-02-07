import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionService } from '../transaction.service';
import { Subscription } from 'rxjs';
import { Transaction } from '../transaction';

const dummyTransactions = [{
  transactionid : 112,
  productquantity : 3,
  transactionamount: 210
},{
  transactionid : 113,
  productquantity : 2,
  transactionamount: 500
}]

@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  userName: any = localStorage.getItem("localVariableUserName");
  private subscription: Subscription;
  transaction :Transaction[]; //comment this if the table is not empty

  constructor(private _transactionService: TransactionService, private router: Router) {  }


  ngOnInit(): void {
    this.subscription=this._transactionService.getTransactions(this.userName)
    .subscribe((data : Transaction[])=>{
      this.transaction = data;
      console.log(this.transaction);
    }, (err : any) =>{
      console.log(err);
    });
  }

 }


