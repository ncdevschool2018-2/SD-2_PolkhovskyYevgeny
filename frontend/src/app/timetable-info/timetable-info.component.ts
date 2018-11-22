import {Component, Input, OnInit} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";

@Component({
  selector: 'app-timetable-info',
  templateUrl: './timetable-info.component.html',
  styleUrls: ['./timetable-info.component.css']
})
export class TimetableInfoComponent implements OnInit {
  @Input()
  public groupNumber:number;

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
