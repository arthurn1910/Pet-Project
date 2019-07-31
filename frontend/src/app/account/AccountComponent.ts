import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/UserService';

@Component({
  selector: 'app-account',
  templateUrl: './accountComponent.html',
  styleUrls: ['./accountComponent.css']
})
export class AccountComponent implements OnInit {
  board: string;
  errorMessage: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAdminBoard().subscribe(
      data => {
        this.board = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
  }
}
