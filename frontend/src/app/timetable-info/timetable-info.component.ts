import {Component, Input, OnInit} from '@angular/core';
import {Timetable} from "../model/timetable";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {TimetableService} from "../service/timetable.service";
import {TimetableExample} from "../model/timetableExample";

@Component({
  selector: 'app-timetable-info',
  templateUrl: './timetable-info.component.html',
  styleUrls: ['./timetable-info.component.css']
})
export class TimetableInfoComponent implements OnInit {


public Monday:string="Monday";
public Tuesday:string="Tuesday";
public Wednesday:string="Wednesday";
public Thursday:string="Thursday";
public Friday:string="Friday";
public Saturday:string="Saturday";
public Sunday:string="Sunday";
  private subscriptions: Subscription[] = [];
  public timetable:TimetableExample[];
  constructor(private loadingService: Ng4LoadingSpinnerService,
              private route: ActivatedRoute,
              private timetableService: TimetableService) { }

  ngOnInit() {/*this.loadTimetable();*/
  this.loadTimetableNamed();
  }

  /*private loadTimetable(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.route.params.subscribe(params => {
      let id: number = +params['id'];
      this.subscriptions.push(this.timetableService.getTimetableByGroupId(id).subscribe(timetable => {
        // Parse json response into local array
        this.timetable = timetable as Timetable[];
        // Check data in console
        this.loadingService.hide();

      }));
    });

  }*/private loadTimetableNamed(): void {
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
