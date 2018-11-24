import {Component, OnInit} from '@angular/core';
import {Teacher} from "../model/teacher";
import {Subscription} from "rxjs";
import {TeacherService} from "../service/teacher.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {PageChangedEvent} from 'ngx-bootstrap/pagination';
@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {
  returnedArray: Teacher[];

  public teachers: Teacher[];
  private subscriptions: Subscription[] = [];

  constructor(private teacherService: TeacherService,
              private loadingService: Ng4LoadingSpinnerService,) {
  }

  ngOnInit() {
    this.loadTeachers();
    this.returnedArray = this.teachers.slice(0, 10);
  }
  pageChanged(event: PageChangedEvent): void {

    const startItem = (event.page - 1) * event.itemsPerPage;
    const endItem = event.page * event.itemsPerPage;
    this.returnedArray = this.teachers.slice(startItem, endItem);
  }
  private loadTeachers(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.teacherService.getTeachers().subscribe(teachers => {
      // Parse json response into local array
      this.teachers = teachers as Teacher[];
      // Check data in console
      //console.log(this.groups);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  public _deleteTeacher(teacherId: string): void {


    this.subscriptions.push(this.teacherService.deleteTeacher(teacherId).subscribe(() => {
      this._updateTeachers();
    }));

  }

  public _updateTeachers(): void {
    this.loadTeachers();
  }
}
