import {Component, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {GroupService} from "../service/group.service";
import {PageGroup} from "../model/pageGroup";


@Component({
  selector: 'app-teacherinfo',
  templateUrl: './teacherinfo.component.html',
  styleUrls: ['./teacherinfo.component.css']
})
export class TeacherinfoComponent implements OnInit {
  oneAtATime: boolean = true;
  isCollapsed = false;
  isCollapsed1 = false;
  isCollapsed2 = false;
  private subscriptions: Subscription[] = [];
  page: PageGroup;
  currentPage: number = 1;


  constructor(private groupService: GroupService,) {
  }

  ngOnInit() {

  }

  /*this.contentArray = this.groups;*/


}
