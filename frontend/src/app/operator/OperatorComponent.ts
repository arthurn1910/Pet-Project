import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {CandidateService} from "../services/CandidateService";


@Component({
  selector: 'app-operator',
  templateUrl: './operatorComponent.html',
  styleUrls: ['./operatorComponent.css']
})
export class OperatorComponent implements OnInit {
  displayedColumns: string[] = ['id', 'name', 'email', 'action'];
  dataSource: MatTableDataSource<unknown> = new MatTableDataSource();

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private candidateService: CandidateService) {
  }

  ngOnInit() {
    this.refresh();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  removeCandidate(id: string) {
    this.candidateService.removeCandidate(id).subscribe(data => {
        this.refresh();
      },
      error => console.log(error)
    );
  }

  refresh() {
    this.candidateService.getCandidates().subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data);
      }
    );
    this.dataSource.sort = this.sort;
  }
}
