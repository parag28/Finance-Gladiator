import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TransactionService } from '../transaction.service';
import { Subscription } from 'rxjs';
import { Transaction } from '../transaction';


@Component({
  selector: 'app-transactions',
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  userName: any = localStorage.getItem("localVariableUserName");
  private subscription: Subscription;
  transaction : Transaction[];

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


