import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emis',
  templateUrl: './emis.component.html',
  styleUrls: ['./emis.component.css']
})
export class EmisComponent implements OnInit {
  userName: string = localStorage.getItem("localVariableUserName");
  constructor() { }

  ngOnInit(): void {
  }

}
