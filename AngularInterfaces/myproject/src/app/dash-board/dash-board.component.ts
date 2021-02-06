import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
@Component({
  selector: 'app-dash-board',
  templateUrl: './dash-board.component.html',
  styleUrls: ['./dash-board.component.css']
})
export class DashBoardComponent implements OnInit {


  constructor(private router:Router) { }

  userName: any = localStorage.getItem("localVariableUserName");
 


  ngOnInit(): void {
  }
  navigate(){
    this.router.navigate(["productlist"]);
  }
  navigate2(){
    this.router.navigate(["userhome"]);
  }

}
