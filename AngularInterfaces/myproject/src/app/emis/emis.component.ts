import { Component, OnInit } from '@angular/core';
import {Card} from '../card';
import {LoginService} from '../login.service';
import {Router} from '@angular/router';
import {CardServiceService} from '../card-service.service';
import {Product} from '../product';
import {Subscription} from 'rxjs/internal/Subscription';

@Component({
  selector: 'app-emis',
  templateUrl: './emis.component.html',
  styleUrls: ['./emis.component.css']
})
export class EmisComponent implements OnInit {
  userName: string|null = localStorage.getItem("localVariableUserName");

  constructor() {
  }

  ngOnInit(): void {

  }

}
