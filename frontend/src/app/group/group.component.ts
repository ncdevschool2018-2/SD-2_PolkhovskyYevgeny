import {Component, Input, OnInit} from '@angular/core';
import {Group} from "../model/group";
import {GroupService} from "../service/group.service";
import {Subscription} from "rxjs";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import { Location } from '@angular/common';
@Component({
  selector: 'app-group',
  templateUrl: './group.component.html',
  styleUrls: ['./group.component.css']
})
export class GroupComponent implements OnInit {

  @Input()
  public timetable: boolean;

groups:Group[];
  private subscriptions: Subscription[] = [];

  
  constructor(private groupService: GroupService,
              private loadingService: Ng4LoadingSpinnerService,
              private location: Location,
              ) {

  }

  ngOnInit() {
    this.loadGroups();
  }
  /*getGroup():void{
    this.groupService.getGroup()
      .subscribe(Group =>this.groups = Group);
  }*/
  private loadGroups(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.groupService.getGroups().subscribe(groups => {
      // Parse json response into local array
      this.groups = groups as Group[];
      // Check data in console
     //console.log(this.groups);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }
  goBack(): void {
    this.location.back();
  }
}
