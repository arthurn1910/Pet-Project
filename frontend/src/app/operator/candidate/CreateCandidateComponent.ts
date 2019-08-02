import {Component, OnInit} from '@angular/core';
import {CandidateInfo} from "../../model/CandidateInfo";
import {CandidateService} from "../../services/CandidateService";

@Component({
  selector: 'app-operator-createCandidate',
  templateUrl: './createCandidateComponent.html',
  styleUrls: ['./createCandidateComponent.css']
})
export class CreateCandidateComponent implements OnInit {
  form: any = {};
  candidateInfo: CandidateInfo;
  isCreated = false;
  isCreatedFailed = false;
  errorMessage = '';

  constructor(private candidateService: CandidateService) {
  }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.form);

    this.candidateInfo = new CandidateInfo(
      this.form.fullName,
      this.form.email
    );

    this.candidateService.createCandidate(this.candidateInfo).subscribe(
      data => {
        this.isCreated = true;
        this.isCreatedFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isCreatedFailed = true;
      }
    );
  }
}
