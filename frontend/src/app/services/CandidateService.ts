import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CandidateInfo} from "../model/CandidateInfo";

@Injectable({
  providedIn: 'root'
})
export class CandidateService {

  private candidatesUrl = 'http://localhost:8080/candidate/list';
  private createCandidateUrl = 'http://localhost:8080/candidate/save';
  private deleteCandidateUrl = 'http://localhost:8080/candidate/remove/';

  constructor(private http: HttpClient) {
  }

  removeCandidate(id) {
    return this.http.delete(this.deleteCandidateUrl + id, id);
  }

  getCandidates(): Observable<any> {
    return this.http.get(this.candidatesUrl, {responseType: 'json'});
  }

  createCandidate(candidateInfo: CandidateInfo) {
    return this.http.post(this.createCandidateUrl, candidateInfo)
  }
}
