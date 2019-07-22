import {Injectable} from '@angular/core';
import {JwtService} from './JwtService'

const TOKEN_KEY = 'AuthToken';
const USERNAME_KEY = 'AuthUsername';
const AUTHORITIES_KEY = 'AuthAuthorities';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  private roles: Array<string> = [];

  constructor() {
  }

  signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
    this.saveUsername(token)
    this.saveAuthorities(token)
  }

  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUsername(token: string) {
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY, JwtService.decodeToken(token).sub);
  }

  public getEmail(): string {
    return sessionStorage.getItem(USERNAME_KEY);
  }

  public saveAuthorities(token: string) {
    window.sessionStorage.removeItem(AUTHORITIES_KEY);
    window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(JwtService.decodeToken(token).autorities));
  }

  public getAuthorities(): string[] {
    this.roles = [];
    this.roles = JwtService.decodeToken(sessionStorage.getItem(TOKEN_KEY)).autorities
    return this.roles;
  }
}
