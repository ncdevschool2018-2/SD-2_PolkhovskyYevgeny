import {Component, OnInit} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {TeacherService} from "../service/teacher.service";
import {Teacher} from "../model/teacher";

@Component({
  selector: 'app-timetable-info-teacher',
  templateUrl: './timetable-info-teacher.component.html',
  styleUrls: ['./timetable-info-teacher.component.css']
})
export class TimetableInfoTeacherComponent implements OnInit {
  public Monday: string = "Monday";
  public Tuesday: string = "Tuesday";
  public Wednesday: string = "Wednesday";
  public Thursday: string = "Thursday";
  public Friday: string = "Friday";
  public Saturday: string = "Saturday";
  public Sunday: string = "Sunday";
  private subscriptions: Subscription[] = [];
  public timetable: TimetableExample[];
 public teacher:Teacher;
  constructor(private route: ActivatedRoute,
              private teacherService: TeacherService,
              ) {
  }

  ngOnInit() {
this.loadTeacher();
  }

  private loadTeacher(): void {
debugger;


    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.teacherService.getTeacher(id).subscribe(teacher => {

        this.teacher = teacher as Teacher;

      }));
    });

  }

}
