import {Component, Input, OnInit} from '@angular/core';
import {Timetable} from "../model/timetable";
import {Subscription} from "rxjs";
import {TimetableService} from "../service/timetable.service";
import {TimetableExample} from "../model/timetableExample";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  @Input()
  public day: string;

  private subscriptions: Subscription[] = [];
  public timetable:TimetableExample[];
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private route: ActivatedRoute,
              private timetableService: TimetableService) { }

  ngOnInit() {
    this.loadTimetableNamed();
    /*this.loadTimetable()*/
  }
  /*private loadTimetable(): void {


    this.subscriptions.push(this.timeTableService.getTimetable().subscribe(timetable => {

      this.timetable = timetable as Timetable[];
    }));
  }*/
  private loadTimetableNamed(): void {
    this.loadingService.show();

    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.timetableService.getTimetableNamedByGroupId(id).subscribe(timetable => {
        // Parse json response into local array
        this.timetable = timetable as TimetableExample[];
        // Check data in console
        this.loadingService.hide();

      }));
    });

  }
}
