import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import {UserService} from "../services/UserService";


@Component({
  selector: 'app-admin',
  templateUrl: './adminComponent.html',
  styleUrls: ['./adminComponent.css']
})
export class AdminComponent implements OnInit{
  displayedColumns: string[] = ['id', 'login', 'action'];
  dataSource: MatTableDataSource<unknown> = new MatTableDataSource();

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getOperators().subscribe(
      data => {
        this.dataSource = new MatTableDataSource(data);
      }
    );
    this.dataSource.sort = this.sort;
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  removeOperator(id: string) {
    this.userService.removeOperator(id);
  }
}
