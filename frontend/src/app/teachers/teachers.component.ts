import { Component, OnInit } from '@angular/core';
import {Teacher} from "../model/teacher";
import {Subscription} from "rxjs";
import {TeacherService} from "../service/teacher.service";
import {Group} from "../model/group";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit {


  public  teachers:Teacher[];
  private subscriptions: Subscription[] = [];
  constructor(private teacherService:TeacherService,
              private loadingService: Ng4LoadingSpinnerService,) { }

  ngOnInit() {
    this.loadTeachers();
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
