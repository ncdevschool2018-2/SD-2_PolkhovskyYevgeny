import {Component, OnInit} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";

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

  public timetable: TimetableExample[];

  constructor() {
  }

  ngOnInit() {

  }

}
