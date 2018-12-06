import {Component, Input, OnInit} from '@angular/core';
import {TimetableExample} from "../model/timetableExample";
import {AccordionConfig} from 'ngx-bootstrap/accordion';
import {Subscription} from "rxjs";
import {TimetableService} from "../service/timetable.service";
import {Slots} from "../model/slots";

export function getAccordionConfig(): AccordionConfig {
  return Object.assign(new AccordionConfig(), {closeOthers: true});
}


@Component({
  selector: 'app-timetable-info',
  templateUrl: './timetable-info.component.html',
  styleUrls: ['./timetable-info.component.css'],
  providers: [{provide: AccordionConfig, useFactory: getAccordionConfig}]
})
export class TimetableInfoComponent implements OnInit {
  @Input()
  public groupNumber: number;
  @Input()
  public roleIdCheck: number=1;
  @Input()
  public slots: Slots[];
  @Input()
  public tChange: boolean;
  public days: string[] = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];
  private subscriptions: Subscription[] = [];
  public Monday: string = "Monday";
  public Tuesday: string = "Tuesday";
  public Wednesday: string = "Wednesday";
  public Thursday: string = "Thursday";
  public Friday: string = "Friday";
  public Saturday: string = "Saturday";
  public Sunday: string = "Sunday";
  public buttonHide: boolean=false;
  public timetable: TimetableExample[];

  constructor(private timetableService: TimetableService,
  ) {
  }

  ngOnInit() {
    this.getButtonHide();
    this.loadTimetableNamed();

  }

  private loadTimetableNamed(): void {


    this.subscriptions.push(this.timetableService.getTimetableNamedByGroupId(this.groupNumber).subscribe(timetable => {

      this.timetable = timetable as TimetableExample[];
    }));
  }

  public test(): void {
    this.loadTimetableNamed();
  }
  public getButtonHide(): void {
    if(this.roleIdCheck==3){
      this.buttonHide=true;
    }
  }

}
