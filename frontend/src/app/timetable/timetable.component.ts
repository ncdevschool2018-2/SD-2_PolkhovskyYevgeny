import { Component, OnInit } from '@angular/core';
import {GroupContent} from "../model/GroupContent";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-timetable',
  templateUrl: './timetable.component.html',
  styleUrls: ['./timetable.component.css']
})
export class TimetableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
