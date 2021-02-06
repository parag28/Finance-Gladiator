import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
import {Card} from '../card';
import {Subscription} from 'rxjs/internal/Subscription';
import {CardServiceService} from '../card-service.service';
@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {


  constructor(private cardService: CardServiceService, private router: Router) {}
  
   

  userName: any = localStorage.getItem("localVariableUserName");
  
  cardTypeDisplay: string|null;
  private subscription: Subscription;
  totalCreditDisplay: number;
  usedCreditDisplay:number;
  cardNameDisplay:string;
  remainingCreditDisplay:number;
  card: Card;

 ngOnInit(): void { 
   if (this.userName != null) {
    this.subscription = this.cardService.getCardByUserName(this.userName).subscribe((data: Card) => {
      this.card = data;
      this.cardNameDisplay = this.userName;
      if (this.card.cardtype == 0) {
        this.cardTypeDisplay = 'Gold';
        this.totalCreditDisplay = 80000;
      } else {
        this.cardTypeDisplay = 'Platinum';
        this.totalCreditDisplay = 100000;
      }
      this.remainingCreditDisplay = this.card.creditremaining;
      this.usedCreditDisplay = this.totalCreditDisplay - this.remainingCreditDisplay;
      console.log(this.card);
    }, (err) => {
      console.log("Error Message is being shown");
      console.log(err);
    });
  }
}

  }
 


