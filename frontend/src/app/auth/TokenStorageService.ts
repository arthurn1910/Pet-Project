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

  static signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
    TokenStorageService.saveUsername(token)
    TokenStorageService.saveAuthorities(token)
  }

  public static getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  public static saveUsername(token: string) {
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY, JwtService.decodeToken(token).sub);
  }

  public static getEmail(): string {
    return sessionStorage.getItem(USERNAME_KEY);
  }

  public static saveAuthorities(token: string) {
    window.sessionStorage.removeItem(AUTHORITIES_KEY);
    window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(JwtService.decodeToken(token).autorities));
  }

  public getAuthorities(): string[] {
    this.roles = [];
    if (sessionStorage.getItem(TOKEN_KEY)) {
      this.roles = JwtService.decodeToken(sessionStorage.getItem(TOKEN_KEY)).autorities
    }
    return this.roles;
  }
}
