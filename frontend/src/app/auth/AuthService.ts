import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

import {AuthLoginInfo} from "./LoginInfo";
import {JwtResponse} from "./JwtResponse";
import {RegisterComponent} from "./RegisterComponent";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:8080/api/auth/login';
  private registerOperator = "http://localhost:8080/api/auth/register"

  constructor(private http: HttpClient) {
  }

  attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(registerInfo: RegisterComponent) {
    return this.http.post<JwtResponse>(this.registerOperator, registerInfo, httpOptions);
  }
}
