import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-createAccount',
  templateUrl: './operatorComponent.html',
  styleUrls: ['./operatorComponent.css']
})
export class OperatorComponent implements OnInit {
  board: string;
  errorMessage: string;

  ngOnInit() {
  }
}
