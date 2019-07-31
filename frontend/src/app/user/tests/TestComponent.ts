import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './testComponent.html',
  styleUrls: ['./testComponent.css']
})
export class TestComponent implements OnInit {
  board: string;
  errorMessage: string;

  constructor() { }

  ngOnInit() {
  }
}
