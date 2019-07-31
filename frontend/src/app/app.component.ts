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
    if (TokenStorageService.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
        if (this.roles.includes('ADMIN')) {
          this.authority = 'ADMIN';
          return false;
        }
        this.authority = 'OPERATOR';
        return true;
    }
  }
}
