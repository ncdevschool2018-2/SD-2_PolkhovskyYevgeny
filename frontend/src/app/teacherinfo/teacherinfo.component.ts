import { Component, OnInit } from '@angular/core';
import {Group} from "../model/group";
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
currentPage:number=1;


  constructor(private groupService: GroupService,) { }

  ngOnInit() {
    this.loadGroups(2);
  }
  private loadGroups(page:number): void {

    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getPageGroups(page).subscribe(page => {
      // Parse json response into local array
      this.page = page as PageGroup;



    }));
    /*this.contentArray = this.groups;*/

  }
  public pageChanged(page:number):void{
    this.loadGroups(page);
  }
}
