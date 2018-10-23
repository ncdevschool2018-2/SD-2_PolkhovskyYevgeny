import { Component, OnInit } from '@angular/core';
import {friday, monday, thursday, tuesday, wednesday} from "../model/timetable";
import {GroupService} from "../service/group.service";
import {PupilService} from "../service/pupil.service";

@Component({
  selector: 'app-pupil',
  templateUrl: './pupil.component.html',
  styleUrls: ['./pupil.component.css']
})
export class PupilComponent implements OnInit {
mondays:monday[];
tuesdays:tuesday[];
wednesdays:wednesday[];
thursdays:thursday[];
fridays:friday[];
  constructor(private pupilService: PupilService) { }

  ngOnInit() {
    this.getMonday();
    this.getTuesday();
    this.getWednesday();
    this.getThursday();
    this.getFriday()
  }
  getMonday():void{
    this.pupilService.getMonday()
      .subscribe(monday =>this.mondays = monday);
  }
  getTuesday():void{
    this.pupilService.getMonday()
      .subscribe(tuesday =>this.tuesdays = tuesday);
  }
  getWednesday():void{
    this.pupilService.getMonday()
      .subscribe(wednesday =>this.wednesdays = wednesday);
  }
  getThursday():void{
    this.pupilService.getMonday()
      .subscribe(thursday =>this.thursdays = thursday);
  }
  getFriday():void{
    this.pupilService.getMonday()
      .subscribe(friday =>this.fridays = friday);
  }

}
