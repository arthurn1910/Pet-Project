import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "./auth/TokenStorageService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'pet-project-fe';
  private roles: string[];
  private authority: string;

  constructor(private tokenStorage: TokenStorageService) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.roles.every(role => {
        if (role === 'ADMIN') {
          this.authority = 'ADMIN';
          return false;
        }
        this.authority = 'user';
        return true;
      });
    }
  }
}
