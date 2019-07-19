import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../auth/TokenStorageService";


@Component({
  selector: 'app-home',
  templateUrl: './homeComponent.html',
  styleUrls: ['./homeComponent.css']
})
export class HomeComponent implements OnInit {
  info: any;

  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getEmail(),
      authorities: this.token.getAuthorities()
    };
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
}
