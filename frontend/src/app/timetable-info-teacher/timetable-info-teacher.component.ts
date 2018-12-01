import {Component, Input, OnInit} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {TeacherService} from "../service/teacher.service";
import {Teacher} from "../model/teacher";
import { AccordionConfig } from 'ngx-bootstrap/accordion';
import {TimetableService} from "../service/timetable.service";
import {Slots} from "../model/slots";
export function getAccordionConfig(): AccordionConfig {
  return Object.assign(new AccordionConfig(), { closeOthers: true });
}
@Component({
  selector: 'app-timetable-info-teacher',
  templateUrl: './timetable-info-teacher.component.html',
  styleUrls: ['./timetable-info-teacher.component.css'],
  providers: [{ provide: AccordionConfig, useFactory: getAccordionConfig }]
})
export class TimetableInfoTeacherComponent implements OnInit {
  @Input()
  public teacherNumber:number;
  @Input()
  public slots: Slots[];
  public days:string[]=["Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"];
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

  constructor(

              private timetableService: TimetableService,
              ) {
  }

  ngOnInit() {
    this.loadTimetableNamed();
  }

  public test(): void {
    this.loadTimetableNamed();
  }
  private loadTimetableNamed(): void {


    this.subscriptions.push(this.timetableService.getTimetableNamedByTeacherId(this.teacherNumber).subscribe(timetable => {
      // Parse json response into local array
      this.timetable = timetable as TimetableExample[];
      // Check data in console


    }));


  }
  /*private loadTeacher(): void {



    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.teacherService.getTeacher(id).subscribe(teacher => {

        this.teacher = teacher as Teacher;

      }));
    });

  }*/


}
