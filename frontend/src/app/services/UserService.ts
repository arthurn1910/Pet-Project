import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private adminUrl = 'http://localhost:8080/user/username/admin';
  private operatorsUrl = 'http://localhost:8080/user/operators';
  private deleteOperatorUrl = 'http://localhost:8080/user/remove/';

  constructor(private http: HttpClient) {
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, {responseType: 'text'});
  }

  getOperators(): Observable<any> {
    return this.http.get(this.operatorsUrl, {responseType: 'json'});
  }

  removeOperator(id) {
    return this.http.delete(this.deleteOperatorUrl + id, id);
  }
}
