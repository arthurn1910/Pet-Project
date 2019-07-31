import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './adminComponent.html',
  styleUrls: ['./adminComponent.css']
})
export class AdminComponent implements OnInit {
  board: string;
  errorMessage: string;

  ngOnInit() {
  }
}
